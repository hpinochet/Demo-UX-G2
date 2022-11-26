package com.example.backendUX.repository;

//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backendUX.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
}
