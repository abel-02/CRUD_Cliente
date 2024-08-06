package com.redo.CRUD_Cliente.controller;

import com.redo.CRUD_Cliente.model.Cliente;
import com.redo.CRUD_Cliente.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteControlador {
    @Autowired
    private ClienteServicio servicio;

    @PostMapping("/cliente")
    public void registrarCliente(@RequestBody Cliente cliente){
        servicio.guardarCliente(cliente);
    }
    @GetMapping("/cliente/{id}")
    public void solicitarCliente(@PathVariable Long id){
        servicio.obtenerCliente(id);
    }
    @DeleteMapping("/cliente/{id}")
    public void eliminarCliente(@PathVariable Long id){
        servicio.eliminarCliente(id);
    }
    @PutMapping("/cliente")
    public void modificarCliente(@RequestBody Cliente cliente){
        servicio.modificarCliente(cliente);
    }
}
