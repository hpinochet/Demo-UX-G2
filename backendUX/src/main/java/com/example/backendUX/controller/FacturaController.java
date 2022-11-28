package com.example.backendUX.controller;

import java.util.*;

import com.example.backendUX.model.PagoFactura;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.model.Factura;
import com.example.backendUX.model.Transaccion;
import com.example.backendUX.service.CuentaService;
import com.example.backendUX.service.FacturaService;
import com.example.backendUX.service.TransaccionService;

@RestController
@CrossOrigin
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

        // Se guarda la nueva factura
        Factura obj = facturaService.save(factura);

        // Se guarda la factura en la cuenta seleccionada (guardando el id de la factura)
        Cuenta cuentaSeleccionada = cuentaService.get(id);
        cuentaSeleccionada.getFacturas().add(obj);
        Cuenta facturaAgregada = cuentaService.save(cuentaSeleccionada);

        new ResponseEntity<Cuenta>(facturaAgregada, HttpStatus.OK);
        return new ResponseEntity<Factura>(obj, HttpStatus.OK);

    }

    //Pagar una nueva factura, 
    @PostMapping(value = "/pagarFactura")
    public ResponseEntity<String> pagarFactura(@RequestBody PagoFactura pagoFactura){

        String Id_factura = pagoFactura.getId_factura();
        String Id_user = pagoFactura.getId_user();

        Cuenta cuenta = cuentaService.get(Id_user);
        Factura factura = facturaService.get(Id_factura);

        int Valor = factura.getMonto();

        // Caso: No tiene suficiente dinero.

        if(cuenta.getSaldo() < Valor){
            return new ResponseEntity<String>("No se tiene suficiente dinero en la cuenta", HttpStatus.OK);
        }

        // Caso: Tiene suficiente dinero

        // Se edita factura en tabla facturas
        factura.setPagado(1);
        facturaService.save(factura);

        // Se edita lista factura en usuario
        List<Factura> facturas = cuenta.getFacturas();
        List<Factura> newFacturas = new ArrayList<Factura>();

        for (Factura f : facturas) {
            if(f.getId().equals(Id_factura)){
                f.setPagado(1);
                newFacturas.add(f);
            }else{
                newFacturas.add(f);
            }
        }

        cuenta.setFacturas(newFacturas);
        cuenta.setSaldo(cuenta.getSaldo() - Valor);


        // Se crea transaccion

        int numero = (10000000 + (new Random().nextInt(99999999 - 10000000)));
        String username = factura.getFactura();

        Date date = new Date();

        String hora = String.valueOf(date.getHours());
        String minuto = String.valueOf(date.getMinutes());

        if(minuto.length() == 1){
            minuto = "0" + minuto;
        }

        String Hora = hora + ":" + minuto;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();

        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(c1.get(Calendar.YEAR));

        String Fecha = dia + "/" + mes + "/" + annio;

        int valorFactura = Valor;

        Transaccion comprobante = new Transaccion(numero,username,Fecha,Hora,valorFactura);
        transaccionService.save(comprobante);

        // Se edita lista transaccion en usuario
        List<Transaccion> transaccionsCuenta = cuenta.getTransacciones();
        transaccionsCuenta.add(comprobante);
        cuenta.setTransacciones(transaccionsCuenta);

        // Se guarda información nueva de la cuenta
        cuentaService.save(cuenta);

        return new ResponseEntity<String>("Pagado", HttpStatus.OK);

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

    // Obtener solamente una factura, esto con el fin de al seleccionar una factura, este muestre la 
    // informacion que contiene dicha factura para proceder con el pago.
    //Seleccionar una cuenta (mediante el id de la factura)
    @GetMapping(value="/findFact/{id}")
    public Factura find(@PathVariable String id){
        return facturaService.get(id);
    }

}
