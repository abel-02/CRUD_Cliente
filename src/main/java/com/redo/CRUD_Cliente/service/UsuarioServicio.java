package com.redo.CRUD_Cliente.service;


import com.redo.CRUD_Cliente.model.Usuario;
import com.redo.CRUD_Cliente.repository.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;

    @Override
    public void guardarUsuario(Usuario usuario) {
        repositorio.save(usuario);
    }
    @Override
    public void eliminarUsuario(Long id) {
        repositorio.deleteById(id);
    }
    @Override
    public void modificarUsuario(Usuario usuario) {
        Optional<Usuario> auxUsuario = this.repositorio.findById(usuario.getId());
        if(auxUsuario.isPresent())
            repositorio.save(usuario);
    }
    @Override
    public Usuario obtenerUsuario(Long id) {
        return repositorio.findById(id).orElse(null);
    }
    @Override
    public List<Usuario> obtenerTodosLosUsuarios(){
        return repositorio.findAll();
    }
}
