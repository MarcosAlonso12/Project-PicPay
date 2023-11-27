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
    private Long firstAccountId;
    @Column(nullable = false)
    private Long secondAccountId;
    @Column(nullable = false)
    private Double value;

    public Transfer() {
    }

    public Transfer(Long id, Long firstAccountId, Long secondAccountId, Double value) {
        this.id = id;
        this.firstAccountId = firstAccountId;
        this.secondAccountId = secondAccountId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirstAccountId() {
        return firstAccountId;
    }

    public void setFirstAccountId(Long firstAccountId) {
        this.firstAccountId = firstAccountId;
    }

    public Long getSecondAccountId() {
        return secondAccountId;
    }

    public void setSecondAccountId(Long secondAccountId) {
        this.secondAccountId = secondAccountId;
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
        return Objects.equals(getId(), transfer.getId()) && Objects.equals(getFirstAccountId(), transfer.getFirstAccountId()) && Objects.equals(getSecondAccountId(), transfer.getSecondAccountId()) && Objects.equals(getValue(), transfer.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstAccountId(), getSecondAccountId(), getValue());
    }
}
