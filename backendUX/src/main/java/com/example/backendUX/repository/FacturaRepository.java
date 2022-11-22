package com.example.backendUX.repository;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backendUX.model.Factura;

@Repository
public interface FacturaRepository extends MongoRepository<Factura, String>{
    
}
