package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Cliente;
import com.redo.CRUD_Cliente.repository.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private IClienteRepositorio repositorio;

    @Override
    public void guardarCliente(Cliente cliente) {
        repositorio.save(cliente);
    }
    @Override
    public void eliminarCliente(Long id) {
        repositorio.deleteById(id);
    }
    @Override
    public void modificarCliente(Cliente cliente) {
        Optional<Cliente> auxCliente = this.repositorio.findById(cliente.getId());
        if(auxCliente.isPresent())
            repositorio.save(cliente);
    }
    @Override
    public Cliente obtenerCliente(Long id) {
        return repositorio.findById(id).orElse(null);
    }
}
