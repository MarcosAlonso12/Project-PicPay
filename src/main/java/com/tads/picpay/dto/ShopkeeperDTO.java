package com.tads.picpay.dto;

import com.tads.picpay.entities.Shopkeeper;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public class ShopkeeperDTO {
    private Long id;

    @NotNull
    private String name;
    @NotNull
    @CNPJ
    private String cnpj;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Double amount;

    public ShopkeeperDTO() {
    }

    public ShopkeeperDTO(Long id, String name, String cnpj, String email, String password, Double amount) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.password = password;
        this.amount = amount;
    }

    public ShopkeeperDTO(Shopkeeper shopkeeper) {
        this.id = shopkeeper.getId();
        this.name = shopkeeper.getName();
        this.cnpj = shopkeeper.getCnpj();
        this.email = shopkeeper.getEmail();
        this.password = shopkeeper.getPassword();
        this.amount = shopkeeper.getAmount();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
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
}
