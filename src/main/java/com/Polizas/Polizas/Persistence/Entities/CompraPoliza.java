package com.Polizas.Polizas.Persistence.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CompraPoliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formaDePago;
    @ManyToOne
    @JoinColumn(name = "poliza_id")
    private Poliza poliza;

    @ManyToOne
        @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToOne
    private Transaccion transaccion;

    private BigDecimal TRM;

    public CompraPoliza(){

    }

    public CompraPoliza(Long id, String formaDePago, Poliza poliza, Usuario usuario, Transaccion transaccion, BigDecimal TRM) {
        this.id = id;
        this.formaDePago = formaDePago;
        this.poliza = poliza;
        this.usuario = usuario;
        this.transaccion = transaccion;
        this.TRM = TRM;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public BigDecimal getTRM() {
        return TRM;
    }

    public void setTRM(BigDecimal TRM) {
        this.TRM = TRM;
    }
}
