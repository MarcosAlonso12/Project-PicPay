package com.tads.picpay.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long payerId;
    @Column(nullable = false)
    private Long receiverId;
    @Column(nullable = false)
    private Double value;

    public Transfer() {
    }

    public Transfer(Long id, Long payerId, Long receiverId, Double value) {
        this.id = id;
        this.payerId = payerId;
        this.receiverId = receiverId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transfer transfer)) return false;
        return Objects.equals(getId(), transfer.getId()) && Objects.equals(getPayerId(), transfer.getPayerId()) && Objects.equals(getReceiverId(), transfer.getReceiverId()) && Objects.equals(getValue(), transfer.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPayerId(), getReceiverId(), getValue());
    }
}
