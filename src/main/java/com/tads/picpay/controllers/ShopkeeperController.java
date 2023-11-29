package com.tads.picpay.controllers;

import com.tads.picpay.dto.ShopkeeperDTO;
import com.tads.picpay.services.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
