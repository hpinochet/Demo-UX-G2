package com.example.backendUX.model;

import java.security.SecureRandom;
import java.util.Date;

//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaccion")
public class Transaccion {

    @Id
    private String id;
    private int numero;
    private String username;
    private String fecha;
    private String hora;
    private int monto;

    public Transaccion(int numero, String username, String fecha, String hora, int monto) {
        this.numero = numero;
        this.username = username;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
