package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private ClienteRepositorio repositorio;
    
    @Override
    public void guardarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Long id) {

    }

    @Override
    public void modificarCliente(Cliente cliente) {

    }

    @Override
    public void obtenerCliente(Long id) {

    }
}
