package com.tads.picpay.services;

import com.tads.picpay.dtos.TransferDTO;
import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.entities.Transfer;
import com.tads.picpay.entities.User;
import com.tads.picpay.entities.enums.UserType;
import com.tads.picpay.exceptions.UnauthorizedException;
import com.tads.picpay.repositories.TransferRepository;
import com.tads.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public TransferDTO transaction(TransferDTO transferDTO) {
        User payer = userRepository.findById(transferDTO.getPayerId()).orElseThrow();
        User receiver = userRepository.findById(transferDTO.getReceiverId()).orElseThrow();
        // Exceções
        if (payer.getUserType() == UserType.SHOPKEEPER) {
            throw new UnauthorizedException("A shopkeeper cannot carry out a transaction");
        }
        if (payer.getAmount() < transferDTO.getAmount()) {
            throw new UnauthorizedException("The user does not have the required amount to make this transaction.");
        }

        // Consulta um serviço externo que autoriza a transação.
        if (!AuthTransactionService.authorizeTransaction()) {
            throw new UnauthorizedException("The transaction is not authorized");
        }

        Transfer transfer = new Transfer(payer, receiver, transferDTO.getAmount());
        Double payerNewAmount = transferDTO.getAmount() - payer.getAmount();
        Double receiverNewAmount = transferDTO.getAmount() + receiver.getAmount();
        payer.setAmount(payerNewAmount);
        receiver.setAmount(receiverNewAmount);

        UserDTO payerDTO = new UserDTO(payer);
        UserDTO receiverDTO = new UserDTO(receiver);

        userService.update(payerDTO.getId(), payerDTO);
        userService.update(receiverDTO.getId(), receiverDTO);
        transfer = transferRepository.save(transfer);

        // Envia uma notificação ao cliente.
        if(!SendNotificationService.send()) {
            throw new UnauthorizedException("Notification not authorized");
        }

        return new TransferDTO(transfer);
    }

}
