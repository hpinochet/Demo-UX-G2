package com.example.backendUX.model;

import java.util.Date;

//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaccion")
public class Transaccion {

    @Id
    private String id;
    private int numero;
    private Date fecha;

    private String hora;

    private int monto;

    public Transaccion(String id, int numero, Date fecha, String hora, int monto) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
    }

    public Transaccion() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
