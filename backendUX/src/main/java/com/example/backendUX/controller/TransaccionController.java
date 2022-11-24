package com.example.backendUX.controller;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import com.example.backendUX.model.Cuenta;
import com.example.backendUX.model.Factura;
import com.example.backendUX.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.example.backendUX.model.Transaccion;
import com.example.backendUX.service.TransaccionService;
import com.example.backendUX.service.CuentaService;

@RestController
@CrossOrigin
@RequestMapping("transaccion")
public class TransaccionController {
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    //Obtener todas las facturas
    @GetMapping(value="/allTr")
    public List<Transaccion> getAll(){
        List<Transaccion> transacciones = transaccionService.getAll();
        return transacciones;
    }


}
