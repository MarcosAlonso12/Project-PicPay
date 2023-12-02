package com.tads.picpay.dtos;

import com.tads.picpay.entities.User;
import com.tads.picpay.entities.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class UserDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    @PositiveOrZero
    private Double amount;
    @NotNull
    private UserType userType;
    @NotNull
    private String identify;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String password, Double amount, UserType userType, String identify) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.amount = amount;
        this.userType = userType;
        this.identify = identify;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.amount = user.getAmount();
        this.userType = user.getUserType();
        this.identify = user.getIdentify();
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

    public UserType getUserType() {
        return userType;
    }

    public String getIdentify() {
        return identify;
    }
}
