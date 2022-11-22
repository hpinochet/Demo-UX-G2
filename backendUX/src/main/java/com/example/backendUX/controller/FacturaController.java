package com.example.backendUX.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.model.Factura;
import com.example.backendUX.model.Transaccion;
import com.example.backendUX.service.CuentaService;
import com.example.backendUX.service.FacturaService;
import com.example.backendUX.service.TransaccionService;

@RestController
@RequestMapping("factura")
public class FacturaController {
    private final FacturaService facturaService;
    private final TransaccionService transaccionService;
    private final CuentaService cuentaService;
    public FacturaController(FacturaService facturaService, TransaccionService transaccionService, CuentaService cuentaService) {
        this.facturaService = facturaService;
        this.transaccionService = transaccionService;
        this.cuentaService = cuentaService;
    }


    //Obtener todas las facturas
    @GetMapping(value="/allFacts")
    public List<Factura> getAll(){
        List<Factura> facturas = facturaService.getAll();
        return facturas;
    }

    //Guardar nueva factura en la cuenta seleccionada (mediante el id de la cuenta seleccionada)
    @PostMapping(value="/saveFact/{id}")
    public ResponseEntity<Factura> save(@RequestBody Factura factura, @PathVariable String id){
        // Se genera de forma automática el comprobante
        Transaccion comprobante = new Transaccion();
        comprobante.setFecha(new Date());
        comprobante.setNumero(10000000 + (new Random().nextInt(99999999 - 10000000)));
        Transaccion guardarComprobante = transaccionService.save(comprobante);

        // Se guarda la informacion del comprobante de transaccion en la factura
        factura.setTransaccion(guardarComprobante);

        // Se guarda la nueva factura
        Factura obj = facturaService.save(factura);

        // Se guarda la factura en la cuenta seleccionada (guardando el id de la factura)
        Cuenta cuentaSeleccionada = cuentaService.get(id);
        cuentaSeleccionada.getFacturas().add(obj);
        Cuenta facturaAgregada = cuentaService.save(cuentaSeleccionada);

        new ResponseEntity<Cuenta>(facturaAgregada, HttpStatus.OK);
        return new ResponseEntity<Factura>(obj, HttpStatus.OK);

        

    }

}
