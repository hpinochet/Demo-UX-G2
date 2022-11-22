package com.example.backendUX.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "factura")
public class Factura {
    @Id
    private String id;
    
    private String nombre_acreedor;
    private String cuenta_acreedor;
    private String fecha;
    private int monto;
    private String mensaje;

    private Transaccion transaccion;

    public Factura(){

    }

    public Factura(String id, String nombre_acreedor, String cuenta_acreedor, String fecha,
            int monto, String mensaje) {
        this.id = id;
        this.nombre_acreedor = nombre_acreedor;
        this.cuenta_acreedor = cuenta_acreedor;
        this.fecha = fecha;
        this.monto = monto;
        this.mensaje = mensaje;
        transaccion = new Transaccion(id, 30, new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_acreedor() {
        return nombre_acreedor;
    }

    public void setNombre_acreedor(String nombre_acreedor) {
        this.nombre_acreedor = nombre_acreedor;
    }

    public String getCuenta_acreedor() {
        return cuenta_acreedor;
    }

    public void setCuenta_acreedor(String cuenta_acreedor) {
        this.cuenta_acreedor = cuenta_acreedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
    
    
}
