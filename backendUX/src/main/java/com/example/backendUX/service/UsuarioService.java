package com.example.backendUX.service;

import java.util.List;

//import com.example.backendUX.model.Cuenta;
import org.springframework.stereotype.Service;

import com.example.backendUX.model.Usuario;
import com.example.backendUX.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener Usuario (como solo existira 1 usuario, se muestra el primero)
    public Usuario getUser(){
        List<Usuario> user = usuarioRepository.findAll();
        if(user.size() != 0){
            return user.get(0);
        }
        else{
            return null;
        }

    }

    // Crear usuario
    public Usuario save(Usuario entity){
        Usuario nuevoUsuario = usuarioRepository.save(entity);
        return nuevoUsuario;
    }

    // Eliminar usuario (solo para probar)
    public void deleteUser(){
        usuarioRepository.deleteAll();
    }

    // Pagar factura

}
