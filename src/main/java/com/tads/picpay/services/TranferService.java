package com.tads.picpay.services;

import java.util.Objects;

public class TranferService {

    private long id;

    private int conta1;


    private int conta2;

    private double valor;

    public TranferService(long id, int conta1, int conta2, double valor) {
        this.id = id;
        this.conta1 = conta1;
        this.conta2 = conta2;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getConta1() {
        return conta1;
    }

    public void setConta1(int conta1) {
        this.conta1 = conta1;
    }

    public int getConta2() {
        return conta2;
    }

    public void setConta2(int conta2) {
        this.conta2 = conta2;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TranferService that)) return false;
        return id == that.id && conta1 == that.conta1 && conta2 == that.conta2 && Double.compare(valor, that.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conta1, conta2, valor);
    }
}
