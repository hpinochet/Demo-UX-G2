package com.example.backendUX.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backendUX.model.Cuenta;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, String>{
    
}
