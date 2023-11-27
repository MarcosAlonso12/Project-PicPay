package com.tads.picpay.dto;

import com.tads.picpay.entities.Transfer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransferDTO {
    private long id;
    @NotNull
    private Long firstAccountId;
    @NotNull
    private Long secondAccountId;
    @NotNull
    @Positive
    private Double value;

    public TransferDTO() {
    }

    public TransferDTO(long id, Long firstAccountId, Long secondAccountId, Double value) {
        this.id = id;
        this.firstAccountId = firstAccountId;
        this.secondAccountId = secondAccountId;
        this.value = value;
    }

    public TransferDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.firstAccountId = transfer.getFirstAccountId();
        this.secondAccountId = transfer.getSecondAccountId();
        this.value = transfer.getValue();
    }

    public long getId() {
        return id;
    }

    public Long getFirstAccountId() {
        return firstAccountId;
    }

    public Long getSecondAccountId() {
        return secondAccountId;
    }

    public Double getValue() {
        return value;
    }
}
