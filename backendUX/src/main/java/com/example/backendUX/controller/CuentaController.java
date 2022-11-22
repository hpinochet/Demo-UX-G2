package com.example.backendUX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Obtener todas las cuentas
    @GetMapping(value="/allCu")
    public List<Cuenta> getAll(){
        List<Cuenta> cuentas = cuentaService.getAll();
        return cuentas;
    }

    //Seleccionar una cuenta
    @GetMapping(value="/findCu/{id}")
    public Cuenta find(@PathVariable String id){
        return cuentaService.get(id);
    }

    //Guardar cuenta (no es parte del sistema, solo para probar)
    @PostMapping(value="/saveCu")
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta){
        Cuenta obj = cuentaService.save(cuenta);
        return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
    }

}
