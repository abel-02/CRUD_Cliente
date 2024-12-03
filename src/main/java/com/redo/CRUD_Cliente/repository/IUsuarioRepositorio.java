package com.redo.CRUD_Cliente.repository;

import com.redo.CRUD_Cliente.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
    @Query("select c from Usuario c where c.email = :email AND c.password = :password")
    List<Usuario> buscarPorEmailYContra(@Param("email") String email,
                                        @Param("password") String password);

}
