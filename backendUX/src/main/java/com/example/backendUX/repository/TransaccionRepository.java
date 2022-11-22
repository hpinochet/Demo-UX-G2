package com.example.backendUX.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backendUX.model.Transaccion;

@Repository
public interface TransaccionRepository extends MongoRepository<Transaccion, String>{
    
}
