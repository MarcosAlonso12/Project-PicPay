package com.tads.picpay.entities;

import com.tads.picpay.entities.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserCommon extends User {
    @Column(nullable = false, unique = true)
    private String cpf;

    public UserCommon() {
    }

    public UserCommon(Long id, String name, String email, String password, Double amount, Type type, String cpf) {
        super(id, name, email, password, amount, type);
        this.cpf = cpf;
    }

    public UserCommon(String name, String email, String password, Double amount, Type type, String cpf) {
        super(name, email, password, amount, type);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
