package com.example.backendUX.model;

import java.util.List;

//import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cuenta")
public class Cuenta {
    @Id
    private String id;
    
    private int numero_cuenta;
    private String tipo_cuenta;
    private String banco;
    private int saldo;

    private List<Factura> facturas;
    private Transaccion transacciones;

    public Cuenta(){

    }



    public Cuenta(String id, int numero_cuenta, String tipo_cuenta, String banco, int saldo, List<Factura> facturas, Transaccion transacciones) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.banco = banco;
        this.saldo = saldo;
        this.facturas = facturas;
        this.transacciones = transacciones;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public int getNumero_cuenta() {
        return numero_cuenta;
    }



    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }



    public String getTipo_cuenta() {
        return tipo_cuenta;
    }



    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }



    public String getBanco() {
        return banco;
    }



    public void setBanco(String banco) {
        this.banco = banco;
    }



    public int getSaldo() {
        return saldo;
    }



    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }



    public List<Factura> getFacturas() {
        return facturas;
    }



    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }



    public Transaccion getTransacciones() {
        return transacciones;
    }



    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }

    
    
}
