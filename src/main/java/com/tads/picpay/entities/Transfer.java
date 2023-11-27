package com.tads.picpay.entities;

public class Transfer {
    private long id;
    private int conta1;
    private int conta2;
    private Double valor;

    public Transfer(long id, int conta1, int conta2, Double valor) {
        this.id = id;
        this.conta1 = conta1;
        this.conta2 = conta2;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

}
