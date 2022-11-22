package com.example.backendUX.model;



import java.util.ArrayList;
import java.util.List;
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

    //listado de Ids de cada factura
    private List<String> IDfacturas = new ArrayList<String>();
    
    //private Transaccion transacciones;

    public Cuenta(){

    }



    public Cuenta(String id, int numero_cuenta, String tipo_cuenta, String banco, int saldo) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.banco = banco;
        this.saldo = saldo;
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



    public List<String> getFacturas() {
        return IDfacturas;
    }



    public void setFacturas(List<String> IDfacturas) {
        this.IDfacturas = IDfacturas;
    }


/* 
    public Transaccion getTransacciones() {
        return transacciones;
    }



    public void setTransacciones(Transaccion transacciones) {
        this.transacciones = transacciones;
    }

   */ 
    
}
