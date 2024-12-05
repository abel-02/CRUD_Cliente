package com.redo.CRUD_Cliente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Se finaliza apenas empieza el proyecto
@EnableWebSecurity
public class SecurityConfiguration {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable); //Evita que se acceda desde otros dominios al sitio web (Lo desabilito para las pruebas)
        http.authorizeHttpRequests(request ->{
            request.requestMatchers("/api/register", "/api/login").permitAll(); //Permite que todos puedan registrarse y logearese
            request.requestMatchers("/api/**").authenticated();                 // Para los demas endpoints debe estar autenticado
        });
        return http.build();
    }
}
