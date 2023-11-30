package com.tads.picpay.services;

import com.tads.picpay.dto.UserCommonDTO;
import com.tads.picpay.entities.UserCommon;
import com.tads.picpay.repositories.UserCommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCommonService {
    @Autowired
    private UserCommonRepository userCommonRepository;

    @Transactional(readOnly = true)
    public UserCommonDTO findById(Long id) {
        return new UserCommonDTO(userCommonRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public Page<UserCommonDTO> findAll(Pageable pageable) {
        return userCommonRepository.findAll(pageable).map(UserCommonDTO::new);
    }

    @Transactional
    public UserCommonDTO insert(UserCommonDTO userCommonDTO) {
        UserCommon userCommon = new UserCommon(
                userCommonDTO.getName(),
                userCommonDTO.getEmail(),
                userCommonDTO.getPassword(),
                userCommonDTO.getAmount(),
                userCommonDTO.getType(),
                userCommonDTO.getCpf()
        );
        userCommon = userCommonRepository.save(userCommon);
        return new UserCommonDTO(userCommon);
    }

    @Transactional
    public UserCommonDTO update(Long id, UserCommonDTO userCommonDTO) {
        try {
            UserCommon userCommon = userCommonRepository.getReferenceById(id);
            userCommon.setName(userCommonDTO.getName());
            userCommon.setEmail(userCommon.getEmail());
            userCommon.setPassword(userCommonDTO.getPassword());
            userCommon.setAmount(userCommonDTO.getAmount());
            userCommon.setType(userCommonDTO.getType());
            userCommon.setCpf(userCommonDTO.getCpf());
            return new UserCommonDTO(userCommon);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            userCommonRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}