package com.example.backendUX.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.repository.CuentaRepository;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    // Listado de cuentas
    public List<Cuenta> getAll(){
        List<Cuenta> list = cuentaRepository.findAll();
        return list;
    }

    // Crear cuenta (solo para prueba, no es parte del sistema)
    public Cuenta save(Cuenta entity){
        Cuenta nuevFactura = cuentaRepository.save(entity);
        return nuevFactura;
    }

    // Obtener cuenta
    public Cuenta get(String id){
        Optional<Cuenta> obj = cuentaRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }
}
