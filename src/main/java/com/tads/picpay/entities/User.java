package com.tads.picpay.entities;

import com.tads.picpay.entities.enums.Type;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, precision = 2)
    private Double amount;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public User() {
    }

    public User(Long id, String name, String email, String password, Double amount, Type type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.type = type;
    }

    public User(String name, String email, String password, Double amount, Type type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}