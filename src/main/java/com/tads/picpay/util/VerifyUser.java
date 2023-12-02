package com.tads.picpay.util;

import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VerifyUser {
    @Autowired
    private UserRepository userRepository;

    public void verifyUser(UserDTO userDTO) {

    }

}
