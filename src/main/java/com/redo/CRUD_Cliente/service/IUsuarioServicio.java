package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public void guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Long id);
    public void modificarUsuario(Usuario usuario);
    public Usuario obtenerUsuario(Long id);
    public List<Usuario> obtenerTodosLosUsuarios();

}
