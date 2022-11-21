package com.example.backendUX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Factura;
import com.example.backendUX.service.FacturaService;

@RestController
@RequestMapping("factura")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    //Obtener todas las facturas
    @GetMapping(value="/all")
    public List<Factura> getAll(){
        List<Factura> facturas = facturaService.getAll();
        return facturas;
    }

    //Guardar nueva factura
    @PostMapping(value="/save")
    public ResponseEntity<Factura> save(@RequestBody Factura factura){
        Factura obj = facturaService.save(factura);
        return new ResponseEntity<Factura>(obj, HttpStatus.OK);
    }

}
