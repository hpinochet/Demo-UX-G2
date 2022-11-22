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


    public Transaccion(){

    }


    public Transaccion(String id, int numero, Date fecha) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
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

    
}
