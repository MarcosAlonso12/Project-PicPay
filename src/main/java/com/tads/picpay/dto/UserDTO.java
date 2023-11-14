package com.tads.picpay.dto;

import com.tads.picpay.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class UserDTO {
    private Long id;

    @NotNull
    private String name;
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Double amount;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String cpf, String email, String password, Double amount) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.amount = amount;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.amount = user.getAmount();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
