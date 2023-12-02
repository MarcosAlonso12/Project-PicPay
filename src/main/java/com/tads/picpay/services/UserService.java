package com.tads.picpay.services;

import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.entities.User;
import com.tads.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return new UserDTO(userRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User(
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getAmount(),
                userDTO.getUserType(),
                userDTO.getIdentify()
        );
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        try {
            User user = userRepository.getReferenceById(id);
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setAmount(userDTO.getAmount());
            user.setUserType(userDTO.getUserType());
            user.setIdentify(userDTO.getIdentify());
            return new UserDTO(user);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
