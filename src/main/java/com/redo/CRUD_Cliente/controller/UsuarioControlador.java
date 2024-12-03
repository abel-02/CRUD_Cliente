package com.redo.CRUD_Cliente.controller;

import com.redo.CRUD_Cliente.model.Usuario;
import com.redo.CRUD_Cliente.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioControlador {
    @Autowired
    private  UsuarioServicio servicio;

    @PostMapping("/usuario")
    public void registrarUsuario(@RequestBody Usuario usuario){
        servicio.guardarUsuario(usuario);
    }
    @GetMapping("/usuario/{id}")
    public Usuario solicitarUsuario(@PathVariable Long id){
        return servicio.obtenerUsuario(id);
    }
    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        servicio.eliminarUsuario(id);
    }
    @PutMapping("/usuario")
    public void modificarUsuario(@RequestBody Usuario usuario){
        servicio.modificarUsuario(usuario);
    }
    @GetMapping("/usuario/todos")
    public List<Usuario> obtenerTodosLosUsuarios(){
        return servicio.obtenerTodosLosUsuarios();
    }
}
