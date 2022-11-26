package com.example.backendUX.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Usuario;
import com.example.backendUX.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //Obtener la informacion del usuario
    @GetMapping(value="/allUs")
    public Usuario getUs(){
        Usuario usuario_unico = usuarioService.getUser();
        return usuario_unico;
    }

    //Guardar un nuevo usuario
    @PostMapping(value = "/saveUs")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.save(usuario);
        return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
    }

    //Eliminar usuario
    @DeleteMapping(value="/deleteUs")
    public void deleteUsuario(){
        usuarioService.deleteUser();
    }

}
