package com.tads.picpay.services;

import com.tads.picpay.dtos.UserDTO;
import com.tads.picpay.entities.User;
import com.tads.picpay.entities.enums.UserType;
import com.tads.picpay.exceptions.DatabaseException;
import com.tads.picpay.repositories.UserRepository;
import com.tads.picpay.util.ConvertIdentify;
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
        return new UserDTO(userRepository.findById(id).orElseThrow(() -> new DatabaseException("This user does not exists.")));
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        try {
            String identify;
            if(userDTO.getUserType() == UserType.COMMON) {
                identify = ConvertIdentify.formatCpf(userDTO.getIdentify());
            } else {
                identify = ConvertIdentify.formatCnpj(userDTO.getIdentify());
            }
            User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getAmount(), userDTO.getUserType(), identify);
            user = userRepository.save(user);
            return new UserDTO(user);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        try {
            String identify;
            if(userDTO.getUserType() == UserType.COMMON) {
                identify = ConvertIdentify.formatCpf(userDTO.getIdentify());
            } else {
                identify = ConvertIdentify.formatCnpj(userDTO.getIdentify());
            }
            userRepository.getReferenceById(id);
            User user = userRepository.getReferenceById(id);
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setAmount(userDTO.getAmount());
            user.setUserType(userDTO.getUserType());
            user.setIdentify(identify);
            return new UserDTO(user);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
