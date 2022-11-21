package com.example.backendUX.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "factura")
public class Factura {
    @Id
    private ObjectId id;
    
    private String nombre_acreedor;
    private String cuenta_acreedor;
    private String fecha;
    private int monto;
    private String mensaje;

   

    public Factura(){

    }

    public Factura(ObjectId id, String nombre_acreedor, String cuenta_acreedor, String fecha,
            int monto, String mensaje) {
        this.id = id;
        this.nombre_acreedor = nombre_acreedor;
        this.cuenta_acreedor = cuenta_acreedor;
        this.fecha = fecha;
        this.monto = monto;
        this.mensaje = mensaje;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre_acreedor() {
        return nombre_acreedor;
    }

    public void setNombre_acreedor(String nombre_acreedor) {
        this.nombre_acreedor = nombre_acreedor;
    }

    public String getCorreo_acreedor() {
        return cuenta_acreedor;
    }

    public void setCorreo_acreedor(String cuenta_acreedor) {
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
    
    
}
