package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private IClienteServicio repositorio;

    @Override
    public void guardarCliente(Cliente cliente) {
        repositorio.guardarCliente(cliente);
    }
    @Override
    public void eliminarCliente(Long id) {
        repositorio.eliminarCliente(id);
    }
    @Override
    public void modificarCliente(Cliente cliente) {
        if(existeCliente(cliente.getId()))
            repositorio.guardarCliente(cliente);
    }
    @Override
    public Cliente obtenerCliente(Long id) {
       if(existeCliente(id))
           return repositorio.obtenerCliente(id);
        return null;
    }
    private boolean existeCliente(Long id){
        Cliente cliente = this.repositorio.obtenerCliente(id);
        if(!(cliente == null))
            return true;
        return false;
    }
}
