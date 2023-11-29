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
    private Long payer;
    @Column(nullable = false)
    private Long receiver;
    @Column(nullable = false)
    private Double value;

    public Transfer() {
    }

    public Transfer(Long id, Long payer, Long secondAccountId, Double value) {
        this.id = id;
        this.payer = payer;
        this.receiver = receiver;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayer() {
        return payer;
    }

    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
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
        return Objects.equals(getId(), transfer.getId()) && Objects.equals(getPayer(), transfer.getPayer()) && Objects.equals(getReceiver(), transfer.getReceiver()) && Objects.equals(getValue(), transfer.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPayer(), getReceiver(), getValue());
    }
}
