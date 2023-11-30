package com.tads.picpay.dto;

import com.tads.picpay.entities.Shopkeeper;
import com.tads.picpay.entities.enums.Type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CNPJ;

public class ShopkeeperDTO {
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
    @CNPJ
    private String cnpj;

    public ShopkeeperDTO() {
    }

    public ShopkeeperDTO(Long id, String name, String email, String password, Double amount, Type type, String cnpj) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.type = type;
        this.cnpj = cnpj;
    }

    public ShopkeeperDTO(Shopkeeper shopkeeper) {
        this.id = shopkeeper.getId();
        this.name = shopkeeper.getName();
        this.email = shopkeeper.getEmail();
        this.password = shopkeeper.getPassword();
        this.amount = shopkeeper.getAmount();
        this.type = shopkeeper.getType();
        this.cnpj = shopkeeper.getCnpj();
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

    public String getCnpj() {
        return cnpj;
    }
}
