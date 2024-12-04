package com.redo.CRUD_Cliente.service;

import com.google.common.hash.Hashing;
import com.redo.CRUD_Cliente.model.Usuario;
import com.redo.CRUD_Cliente.repository.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AutService implements IAutService{

    private static final String PALABRA_SECRETA = "masindescifrable";
    @Autowired
    private IUsuarioRepositorio repositorio;

    @Override
    public Usuario login(String email, String password) {
        String hashPassword = Hashing.sha256()
                .hashString(password + PALABRA_SECRETA, StandardCharsets.UTF_8)
                .toString();
        List<Usuario> resultado = repositorio.buscarPorEmailYContra(email, hashPassword);
        if(resultado.isEmpty()){
            // No encontró el usuario
            return null;
        }else{
            // Encontró el usuario
            return resultado.get(0);
        }

    }
}
