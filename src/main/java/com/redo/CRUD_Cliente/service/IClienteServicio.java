package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Cliente;

import java.util.List;

public interface IClienteServicio {
    public void guardarCliente(Cliente cliente);
    public void eliminarCliente(Long id);
    public void modificarCliente(Cliente cliente);
    public Cliente obtenerCliente(Long id);
    public List<Cliente> obtenerTodosLosClientes();

}
