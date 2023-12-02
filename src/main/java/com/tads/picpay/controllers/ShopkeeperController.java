package com.tads.picpay.controllers;

import com.tads.picpay.dto.ShopkeeperDTO;
import com.tads.picpay.services.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/shopkeepers")
public class ShopkeeperController {
    @Autowired
    private ShopkeeperService shopkeeperService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ShopkeeperDTO> findById(@PathVariable Long id) {
        ShopkeeperDTO shopkeeperDTO = shopkeeperService.findById(id);
        return ResponseEntity.ok(shopkeeperDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ShopkeeperDTO>> findAll(Pageable pageable) {
        Page<ShopkeeperDTO> shopkeeperDTOS = shopkeeperService.findAll(pageable);
        return ResponseEntity.ok(shopkeeperDTOS);
    }

    @PostMapping
    public ResponseEntity<ShopkeeperDTO> insert(@RequestBody ShopkeeperDTO shopkeeperDTO) {
        shopkeeperDTO = shopkeeperService.insert(shopkeeperDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shopkeeperDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(shopkeeperDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ShopkeeperDTO> update(@PathVariable Long id, @RequestBody ShopkeeperDTO shopkeeperDTO) {
        shopkeeperDTO = shopkeeperService.update(id, shopkeeperDTO);
        return ResponseEntity.ok(shopkeeperDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        shopkeeperService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
