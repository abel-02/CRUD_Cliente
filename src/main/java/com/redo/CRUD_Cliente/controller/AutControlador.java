package com.redo.CRUD_Cliente.controller;

import com.redo.CRUD_Cliente.dto.RequestLogin;
import com.redo.CRUD_Cliente.model.Usuario;
import com.redo.CRUD_Cliente.service.AutService;
import com.redo.CRUD_Cliente.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//El cierre de sesion no sera necesario porque la info la guarda el cliente (jwt)
@RestController
@RequestMapping("/api/auth")
public class AutControlador {
    @Autowired
    private AutService servicio;

    @PostMapping("/login")
    public String login(@RequestBody RequestLogin request){
        String emailIngresado = request.getEmail();
        String passwordIngresada = request.getPassword();
        Usuario usuarioAutenticado = servicio.login(emailIngresado, passwordIngresada);
        String tokenDeSesion = JwtUtil.generarToken(usuarioAutenticado);

        return tokenDeSesion;
    }
}
