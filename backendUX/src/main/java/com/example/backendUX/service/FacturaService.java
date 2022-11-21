package com.example.backendUX.service;

import java.util.List;

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

    // Crear factura
    public Factura save(Factura entity){
        Factura nuevFactura = facturaRepository.save(entity);
        return nuevFactura;
    }
}
