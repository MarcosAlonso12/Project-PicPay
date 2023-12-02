package com.tads.picpay.services;

import com.tads.picpay.dto.ShopkeeperDTO;
import com.tads.picpay.entities.Shopkeeper;
import com.tads.picpay.repositories.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopkeeperService {
    @Autowired
    private ShopkeeperRepository shopkeeperRepository;

    public ShopkeeperDTO findById(Long id) {
        return new ShopkeeperDTO(shopkeeperRepository.findById(id).orElseThrow(() -> new RuntimeException("Teste")));
    }

    @Transactional(readOnly = true)
    public Page<ShopkeeperDTO> findAll(Pageable pageable) {
        return shopkeeperRepository.findAll(pageable).map(ShopkeeperDTO::new);
    }

    @Transactional
    public ShopkeeperDTO insert(ShopkeeperDTO shopkeeperDTO) {
        Shopkeeper shopkeeper = new Shopkeeper(
                shopkeeperDTO.getName(),
                shopkeeperDTO.getEmail(),
                shopkeeperDTO.getPassword(),
                shopkeeperDTO.getAmount(),
                shopkeeperDTO.getType(),
                shopkeeperDTO.getCnpj()
        );
        shopkeeper = shopkeeperRepository.save(shopkeeper);
        return new ShopkeeperDTO(shopkeeper);
    }

    @Transactional
    public ShopkeeperDTO update(Long id, ShopkeeperDTO shopkeeperDTO) {
        try {
            Shopkeeper shopkeeper = shopkeeperRepository.getReferenceById(id);
            shopkeeper.setName(shopkeeperDTO.getName());
            shopkeeper.setEmail(shopkeeperDTO.getEmail());
            shopkeeper.setPassword(shopkeeperDTO.getPassword());
            shopkeeper.setAmount(shopkeeperDTO.getAmount());
            shopkeeper.setType(shopkeeperDTO.getType());
            shopkeeper.setCnpj(shopkeeperDTO.getCnpj());
            return new ShopkeeperDTO(shopkeeper);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            shopkeeperRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
