package com.tads.picpay.controllers;

import com.tads.picpay.dto.UserCommonDTO;
import com.tads.picpay.services.UserCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserCommonController {
    @Autowired
    private UserCommonService userCommonService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCommonDTO> findById(@PathVariable Long id) {
        UserCommonDTO userCommonDTO = userCommonService.findById(id);
        return ResponseEntity.ok(userCommonDTO);
    }

    @GetMapping
    public ResponseEntity<Page<UserCommonDTO>> findAll(Pageable pageable) {
        Page<UserCommonDTO> userCommonDTOS = userCommonService.findAll(pageable);
        return ResponseEntity.ok(userCommonDTOS);
    }

    @PostMapping
    public ResponseEntity<UserCommonDTO> insert(@RequestBody UserCommonDTO userCommonDTO) {
        userCommonDTO = userCommonService.insert(userCommonDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCommonDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userCommonDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserCommonDTO> update(@PathVariable Long id, @RequestBody UserCommonDTO userCommonDTO) {
        userCommonDTO = userCommonService.update(id, userCommonDTO);
        return ResponseEntity.ok(userCommonDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userCommonService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
