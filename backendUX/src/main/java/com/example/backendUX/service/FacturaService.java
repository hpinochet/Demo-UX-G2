package com.example.backendUX.service;

import java.util.List;
import java.util.Optional;

import com.example.backendUX.model.Cuenta;
import org.springframework.stereotype.Service;

import com.example.backendUX.model.Factura;
import com.example.backendUX.repository.FacturaRepository;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    // Listado de facturas
    public List<Factura> getAll(){
        List<Factura> list = facturaRepository.findAll();
        return list;
    }

    public Factura get(String id){
        Optional<Factura> obj = facturaRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    // Crear factura
    public Factura save(Factura entity){
        Factura nuevFactura = facturaRepository.save(entity);
        return nuevFactura;
    }

    // Pagar factura

}
