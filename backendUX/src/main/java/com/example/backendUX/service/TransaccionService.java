package com.example.backendUX.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backendUX.model.Transaccion;
import com.example.backendUX.repository.TransaccionRepository;

@Service
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    // Listado de facturas
    public List<Transaccion> getAll(){
        List<Transaccion> list = transaccionRepository.findAll();
        return list;
    }

    // Crear factura
    public Transaccion save(Transaccion entity){
        Transaccion nuevaTransaccion = transaccionRepository.save(entity);
        return nuevaTransaccion;
    }
}
