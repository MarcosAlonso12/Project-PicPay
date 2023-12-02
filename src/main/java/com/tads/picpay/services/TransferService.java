package com.tads.picpay.services;

import com.tads.picpay.dtos.TransferDTO;
import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.entities.Transfer;
import com.tads.picpay.entities.User;
import com.tads.picpay.entities.enums.UserType;
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

    @Transactional(readOnly = true)
    public Page<TransferDTO> findAll(Pageable pageable) {
        return transferRepository.findAll(pageable).map(TransferDTO::new);
    }

    @Transactional
    public TransferDTO transaction(TransferDTO transferDTO) {
        if (Objects.equals(transferDTO.getPayerId(), transferDTO.getReceiverId())) {
            throw new RuntimeException("Mesmo id");
        }

        User payer = userRepository.findById(transferDTO.getPayerId()).orElseThrow();
        User receiver = userRepository.findById(transferDTO.getReceiverId()).orElseThrow();

        if (payer.getUserType() == UserType.SHOPKEEPER) {
            throw new RuntimeException("O Pagador nao pode ser um lojista.");
        }

        if (payer.getAmount() < transferDTO.getValue()) {
            throw new RuntimeException("O pagador não possui o valor a ser enviado.l");
        }

        // Consulta um serviço externo que autoriza a transação.
        if (!AuthTransactionService.authorizeTransaction()) {
            throw new RuntimeException("TRANSFERENCIA NAO AUTORIZADA.");
        }

        Transfer transfer = new Transfer(payer, receiver, transferDTO.getValue());

        Double payerNewAmount = transferDTO.getValue() - payer.getAmount();
        Double receiverNewAmount = transferDTO.getValue() + receiver.getAmount();
        payer.setAmount(payerNewAmount);
        receiver.setAmount(receiverNewAmount);

        UserDTO payerDTO = new UserDTO(payer);
        UserDTO receiverDTO = new UserDTO(receiver);

        userService.update(payerDTO.getId(), payerDTO);
        userService.update(receiverDTO.getId(), receiverDTO);
        transfer = transferRepository.save(transfer);

        // Envia uma notificação ao cliente.
        SendNotificationService.send();

        return new TransferDTO(transfer);
    }

}
