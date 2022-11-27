package com.example.backendUX.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendUX.model.Cuenta;
import com.example.backendUX.model.Usuario;
import com.example.backendUX.service.CuentaService;
import com.example.backendUX.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final CuentaService cuentaService;
    public UsuarioController(UsuarioService usuarioService, CuentaService cuentaService) {
        this.usuarioService = usuarioService;
        this.cuentaService = cuentaService;
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

    //Crear cuenta y guardarlo en usuario (mediante el id)
    @PostMapping(value = "/nuevaCuenta/{id}")
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta, @PathVariable String id){
        // Se guarda la cuenta en la coleccion de cuentas
        Cuenta nueva_cuenta = cuentaService.save(cuenta);

        // Se guarda la cuenta dentro del usuario seleccionado
        Usuario usuarioSeleccionado = usuarioService.getUser();
        usuarioSeleccionado.getCuentas().add(nueva_cuenta);
        Usuario cuentaAgregada = usuarioService.save(usuarioSeleccionado);

        new ResponseEntity<Usuario>(cuentaAgregada, HttpStatus.OK);
        return new ResponseEntity<Cuenta>(nueva_cuenta, HttpStatus.OK);
    }

}
