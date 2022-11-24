package com.example.backendUX.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.model.Factura;
import com.example.backendUX.model.Transaccion;
import com.example.backendUX.service.CuentaService;

@RestController
@CrossOrigin
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

    //Obtener todos los comprobante de pago de cada factura en la cuenta seleccionada
    @GetMapping(value="/allFC/{id}")
    public List<Transaccion> getAllFact(@PathVariable String id){
        Cuenta cuentaSeleccionada = cuentaService.get(id);
        List<Factura> facturas_x_cuenta = cuentaSeleccionada.getFacturas();
        
        List<Transaccion> Transacciones_x_cuenta = new ArrayList<Transaccion>();
        for (Factura f : facturas_x_cuenta) {
            Transacciones_x_cuenta.add(f.getTransaccion());
        }

        return Transacciones_x_cuenta;
    }

    // Iniciar sesion
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody Cuenta cuenta){
        List<Cuenta> cuentas = cuentaService.getAll();

        String username = cuenta.getUsername();
        String password = cuenta.getPassword();

        int userFlag = 0;
        int passwordFlag = 0;

        for (Cuenta f : cuentas) {
            if(f.getUsername().equals(username)){
                userFlag = 1;
                if(f.getPassword().equals(password)){
                    passwordFlag = 1;
                }
            }
        }

        System.out.println(userFlag);
        System.out.println(passwordFlag);

        if(userFlag == 0){
            return new ResponseEntity<String>("No existe una cuenta con este RUT", HttpStatus.OK);
        }
        if(passwordFlag == 0){
            return new ResponseEntity<String>("La contraseña de la cuenta es incorrecta", HttpStatus.OK);
        }
        return new ResponseEntity<String>("OK", HttpStatus.OK);

    }

    //Obtener todas las transacciones por cada cuenta

}
