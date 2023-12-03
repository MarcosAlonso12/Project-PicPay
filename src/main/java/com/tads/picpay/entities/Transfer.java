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
    private Double amount;

    public Transfer() {
    }

    public Transfer(Long id, User payer, User receiver, Double amount) {
        this.id = id;
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Transfer(User payer, User receiver, Double amount) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double value) {
        this.amount = amount;
    }
}
