package com.redo.CRUD_Cliente.controller;

import com.redo.CRUD_Cliente.model.Cliente;
import com.redo.CRUD_Cliente.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteControlador {
    @Autowired
    private ClienteServicio servicio;

    @PostMapping("/cliente")
    public void registrarCliente(@RequestBody Cliente cliente){
        servicio.guardarCliente(cliente);
    }
    @GetMapping("/cliente/{id}")
    public Cliente solicitarCliente(@PathVariable Long id){
        return servicio.obtenerCliente(id);
    }
    @DeleteMapping("/cliente/{id}")
    public void eliminarCliente(@PathVariable Long id){
        servicio.eliminarCliente(id);
    }
    @PutMapping("/cliente")
    public void modificarCliente(@RequestBody Cliente cliente){
        servicio.modificarCliente(cliente);
    }
    @GetMapping("/cliente/todos")
    public List<Cliente> obtenerTodosLosClientes(){
        return servicio.obtenerTodosLosClientes();
    }
}
