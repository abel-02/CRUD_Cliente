package com.redo.CRUD_Cliente.config;

import com.redo.CRUD_Cliente.utils.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class CustomAccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        boolean authorized = isAuthorized(request);
        // Si esta autorizado, le da una autenticacion a la request
        if (authorized) {
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList()));
            filterChain.doFilter(request, response);
        } else {
            // Sino le da un 403 (forbidden)
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
    private boolean isAuthorized(HttpServletRequest request) {
        //url de la request
        String currentUrl = request.getRequestURI();
        //Url permitidas para todos (se puede mover a un property)
        String[] availableUrl = new String[] {
                "/api/auth/login",
                "/api/auth/register"
        };
        // Si la url esta en la lista de permitidas, estara autorizado
        boolean authorized = Arrays.asList(availableUrl).contains(currentUrl);
        boolean isApiResource = currentUrl.startsWith("/api/");
        // Si está autorizada para todos
        if (authorized || !isApiResource) {
            return true;
        }

        try {
            // Si no, se revisa si tiene el acceso por token
            String token = request.getHeader("Authorization");
            String userId = JwtUtil.obtenerUsuarioPorToken(token);
            return true;
        } catch(Exception e) {
            //Si no es una url con acceso publico y la request no tiene el token con permisos, se niega la autorizacion
            return false;
        }
    }
}
