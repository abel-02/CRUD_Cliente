package com.redo.CRUD_Cliente.repository;

import com.redo.CRUD_Cliente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
