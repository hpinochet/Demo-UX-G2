package com.example.backendUX.model;

public class PagoFactura {

    private String id_factura;
    private String id_user;


    public PagoFactura(String id_factura, String id_user, int valor) {
        this.id_factura = id_factura;
        this.id_user = id_user;

    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

}
