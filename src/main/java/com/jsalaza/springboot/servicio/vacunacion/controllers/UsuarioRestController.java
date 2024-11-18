package com.jsalaza.springboot.servicio.vacunacion.controllers;

import com.jsalaza.springboot.servicio.vacunacion.configuration.JWTAuthtenticationConfig;
import com.jsalaza.springboot.servicio.vacunacion.domain.UserDto;
import com.jsalaza.springboot.servicio.vacunacion.services.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class UsuarioRestController {

    private final JWTAuthtenticationConfig jwtAuthtenticationConfig;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public UserDto login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        try {
            // Validar las credenciales del usuario
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            // Comprobar si la contraseña es correcta
            if (userDetails.getPassword().equals(encryptedPass)) {
                // Si las credenciales son correctas, generar el JWT
                String token = jwtAuthtenticationConfig.getJWTToken(username);
                return new UserDto(username, encryptedPass, token);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado");
        }


    }

}

