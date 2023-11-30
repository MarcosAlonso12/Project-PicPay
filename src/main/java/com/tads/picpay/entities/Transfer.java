package com.tads.picpay.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @Column(nullable = false)
    private Double value;

    public Transfer() {
    }

    public Transfer(Long id, User payer, User receiver, Double value) {
        this.id = id;
        this.payer = payer;
        this.receiver = receiver;
        this.value = value;
    }

    public Transfer(User payer, User receiver, Double value) {
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

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
