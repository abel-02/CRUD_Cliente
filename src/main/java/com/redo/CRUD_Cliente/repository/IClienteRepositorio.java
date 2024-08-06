package com.redo.CRUD_Cliente.repository;

import com.redo.CRUD_Cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepositorio extends JpaRepository<Long, Cliente> {
}
