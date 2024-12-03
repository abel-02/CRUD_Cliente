package com.redo.CRUD_Cliente.service;

import com.redo.CRUD_Cliente.model.Usuario;

public interface IAutService {
    Usuario login(String email, String password);
}
