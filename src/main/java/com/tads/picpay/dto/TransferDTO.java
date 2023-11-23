package com.tads.picpay.dto;

import com.tads.picpay.entities.Transfer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

public class TransferDTO {

    private long id;
@NotNull
@Positive
    private  int conta1;
@NotNull
@Positive
    private int conta2;
@NotNull
@Positive
    private double valor;

@NotNull
@Positive

    public TransferDTO(long id, int conta1, int conta2, double valor) {
        this.id = id;
        this.conta1 = conta1;
        this.conta2 = conta2;
        this.valor = valor;
    }

    public TransferDTO(Transfer transfer){
      this.id = transfer.getId();
      this.conta1 = transfer.getConta1();
      this.conta2 = transfer.getConta2();
      this.valor = transfer.getValor();

    }

    public long getId() {
        return id;
    }

    public int getConta1() {
        return conta1;
    }


    public int getConta2() {
        return conta2;
    }


    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferDTO that)) return false;
        return id == that.id && conta1 == that.conta1 && conta2 == that.conta2 && Double.compare(valor, that.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conta1, conta2, valor);
    }
}
