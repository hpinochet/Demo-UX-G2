package com.example.backendUX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Transaccion;
import com.example.backendUX.service.TransaccionService;

@RestController
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

    //Guardar nueva factura
    @PostMapping(value="/saveTr")
    public ResponseEntity<Transaccion> save(@RequestBody Transaccion transaccion){
        Transaccion obj = transaccionService.save(transaccion);
        return new ResponseEntity<Transaccion>(obj, HttpStatus.OK);
    }

}
