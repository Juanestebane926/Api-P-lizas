package com.Polizas.Polizas.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;
    private BigDecimal monto;
    private String moneda;

    public Transaccion() {
    }


    public Transaccion(Long id, BigDecimal monto, String moneda) {
        Id = id;
        this.monto = monto;
        this.moneda = moneda;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "Id=" + Id +
                ", monto=" + monto +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}
