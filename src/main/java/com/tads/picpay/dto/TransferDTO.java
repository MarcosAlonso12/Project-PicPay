package com.tads.picpay.dto;

import com.tads.picpay.entities.Transfer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransferDTO {
    private long id;
    @NotNull
    private Long payer;
    @NotNull
    private Long receiver;
    @NotNull
    @Positive
    private Double value;

    public TransferDTO() {
    }

    public TransferDTO(long id, Long payer, Long secondAccountId, Double value) {
        this.id = id;
        this.payer = payer;
        this.receiver = receiver;
        this.value = value;
    }

    public TransferDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.payer = transfer.getPayer();
        this.receiver = transfer.getReceiver();
        this.value = transfer.getValue();
    }

    public long getId() {
        return id;
    }

    public Long getPayer() {
        return payer;
    }

    public Long getReceiver() {
        return payer;
    }

    public Double getValue() {
        return value;
    }
}
