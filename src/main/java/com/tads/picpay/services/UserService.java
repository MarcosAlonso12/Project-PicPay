package com.tads.picpay.services;

import com.tads.picpay.dto.UserDTO;
import com.tads.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id) {
        return new UserDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Teste")));
    }

}
