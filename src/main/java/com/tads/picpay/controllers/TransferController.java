package com.tads.picpay.controllers;

import com.tads.picpay.dtos.TransferDTO;
import com.tads.picpay.exceptions.InvalidInformationException;
import com.tads.picpay.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/transaction")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferDTO> insert(@RequestBody TransferDTO transferDTO) {
        if (Objects.equals(transferDTO.getPayerId(), transferDTO.getReceiverId())) {
            throw new InvalidInformationException("It is not possible to make a transfer to the same ID.");
        }
        transferDTO = transferService.transaction(transferDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(transferDTO);
    }
}
