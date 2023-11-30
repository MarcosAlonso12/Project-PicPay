package com.tads.picpay.dto;

import com.tads.picpay.entities.UserCommon;
import com.tads.picpay.entities.enums.Type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CPF;

public class UserCommonDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Positive
    private Double amount;
    @NotNull
    private Type type;
    @NotNull
    @CPF
    private String cpf;

    public UserCommonDTO() {
    }

    public UserCommonDTO(Long id, String name, String email, String password, Double amount, Type type, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.type = type;
        this.cpf = cpf;
    }

    public UserCommonDTO(UserCommon userCommon) {
        this.id = userCommon.getId();
        this.name = userCommon.getName();
        this.email = userCommon.getEmail();
        this.password = userCommon.getPassword();
        this.amount = userCommon.getAmount();
        this.type = userCommon.getType();
        this.cpf = userCommon.getCpf();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Double getAmount() {
        return amount;
    }

    public Type getType() {
        return type;
    }

    public String getCpf() {
        return cpf;
    }
}
