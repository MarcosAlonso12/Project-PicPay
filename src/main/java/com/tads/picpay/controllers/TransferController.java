package com.tads.picpay.controllers;

import com.tads.picpay.dtos.TransferDTO;
import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transaction")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public ResponseEntity<Page<TransferDTO>> findAll(Pageable pageable) {
        Page<TransferDTO> transferDTOS = transferService.findAll(pageable);
        return ResponseEntity.ok(transferDTOS);
    }

    @PostMapping
    public ResponseEntity<TransferDTO> insert(@RequestBody TransferDTO transferDTO) {
        transferDTO = transferService.transaction(transferDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(transferDTO);
    }
}
