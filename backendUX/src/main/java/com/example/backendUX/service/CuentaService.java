package com.example.backendUX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.repository.CuentaRepository;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    // Listado de facturas
    public List<Cuenta> getAll(){
        List<Cuenta> list = cuentaRepository.findAll();
        return list;
    }

    // Crear factura
    public Cuenta save(Cuenta entity){
        Cuenta nuevFactura = cuentaRepository.save(entity);
        return nuevFactura;
    }
}
