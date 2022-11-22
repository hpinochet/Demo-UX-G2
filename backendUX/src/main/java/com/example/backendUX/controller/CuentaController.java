package com.example.backendUX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.service.CuentaService;

@RestController
@RequestMapping("cuenta")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    //Obtener todas las facturas
    @GetMapping(value="/allCu")
    public List<Cuenta> getAll(){
        List<Cuenta> cuentas = cuentaService.getAll();
        return cuentas;
    }

    //Guardar nueva factura
    @PostMapping(value="/saveCu")
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        Cuenta obj = cuentaService.save(cuenta);
        return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
    }

}
