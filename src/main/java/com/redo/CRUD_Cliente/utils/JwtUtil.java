package com.redo.CRUD_Cliente.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.redo.CRUD_Cliente.model.Usuario;

import java.util.Date;

// Documentacion token auth0 https://www.baeldung.com/java-auth0-jwt

public class JwtUtil {

    private static final String PALABRA_SECRETA = "masindescifrable";

    public static String generarToken(Usuario usuario){
        Algorithm algorithm = Algorithm.HMAC256(PALABRA_SECRETA);
        String token = JWT.create()
                .withIssuer("redo")
                .withClaim("userId",usuario.getId().toString())
                .withExpiresAt(new Date())
                .withExpiresAt(obtenerFechaExpiracion())
                .sign(algorithm);
        return token;
    }

    private static Date obtenerFechaExpiracion() {
        return new Date(System.currentTimeMillis()
        + (1000L * 60 * 60 *24 * 14));
    }
/*
    public Usuario obtenerUsuarioPorToken(String token){
        //Podemos poner fecha limite de sesion y en caso de pasarse, poner sesion expirada
        return null;
    }
 */
}
