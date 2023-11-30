package com.tads.picpay.entities;

import com.tads.picpay.entities.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopkeepers")
public class Shopkeeper extends User{
    @Column(nullable = false, unique = true)
    private String cnpj;

    public Shopkeeper() {
    }

    public Shopkeeper(Long id, String name, String email, String password, Double amount, Type type, String cnpj) {
        super(id, name, email, password, amount, type);
        this.cnpj = cnpj;
    }

    public Shopkeeper(String name, String email, String password, Double amount, Type type, String cnpj) {
        super(name, email, password, amount, type);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
