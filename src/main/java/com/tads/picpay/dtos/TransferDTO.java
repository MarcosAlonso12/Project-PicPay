package com.tads.picpay.dtos;

import com.tads.picpay.entities.Transfer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransferDTO {
    private Long id;
    @NotNull
    private Long payerId;
    @NotNull
    private Long receiverId;
    @NotNull
    @Positive
    private Double value;

    public TransferDTO() {
    }

    public TransferDTO(Long id, Long payerId, Long receiverId, Double value) {
        this.id = id;
        this.payerId = payerId;
        this.receiverId = receiverId;
        this.value = value;
    }

    public TransferDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.payerId = transfer.getPayer().getId();
        this.receiverId = transfer.getReceiver().getId();
        this.value = transfer.getValue();
    }

    public Long getId() {
        return id;
    }

    public Long getPayerId() {
        return payerId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public Double getValue() {
        return value;
    }
}