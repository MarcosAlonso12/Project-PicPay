package com.tads.picpay.dto;

import com.tads.picpay.entities.Transfer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransferDTO {
    private long id;
    @NotNull
    private Long payerId;
    @NotNull
    private Long receiverId;
    @NotNull
    @Positive
    private Double value;

    public TransferDTO() {
    }

    public TransferDTO(long id, Long payerId, Long receiverId, Double value) {
        this.id = id;
        this.payerId = payerId;
        this.receiverId = receiverId;
        this.value = value;
    }

    public TransferDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.payerId = transfer.getPayerId();
        this.receiverId = transfer.getReceiverId();
        this.value = transfer.getValue();
    }

    public long getId() {
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
