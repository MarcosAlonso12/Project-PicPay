package com.tads.picpay.services;

import com.tads.picpay.dto.ShopkeeperDTO;
import com.tads.picpay.repositories.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopkeeperService {
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public ShopkeeperDTO findById(Long id) {
        return new ShopkeeperDTO(shopkeeperRepository.findById(id).orElseThrow(() -> new RuntimeException("Teste")));
    }
}
