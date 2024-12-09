package com.jsalaza.springboot.servicio.vacunacion.controllers;

import com.jsalaza.springboot.servicio.vacunacion.configuration.JWTAuthtenticationConfig;
import com.jsalaza.springboot.servicio.vacunacion.domain.UserDto;
import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import com.jsalaza.springboot.servicio.vacunacion.repository.IUsuarioDao;
import com.jsalaza.springboot.servicio.vacunacion.services.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequiredArgsConstructor
@Slf4j
public class UsuarioRestController {

    private final JWTAuthtenticationConfig jwtAuthtenticationConfig;
    private final CustomUserDetailsService customUserDetailsService;
    @Autowired
    private IUsuarioDao usuarioRepository;



    @PostMapping("/login")
    public UserDto login(@RequestBody Usuario usuario) {
        log.info("ingreso a login " + usuario);
        try {
            // Validar las credenciales del usuario
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(usuario.getUsername());

            // Comprobar si la contraseña es correcta
            if (userDetails.getPassword().equals(usuario.getPassword())) {
                // Si las credenciales son correctas, generar el JWT
                String token = jwtAuthtenticationConfig.getJWTToken(usuario.getUsername());
                Usuario usuarioEntity = usuarioRepository.findByUsername(usuario.getUsername())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado"));

                Integer idEmpleado = usuarioEntity.getEmpleado() != null ? usuarioEntity.getEmpleado().getIdempleado() : null;
                // Obtener los roles del usuario
               // return new UserDto(usuario.getUsername(), usuario.getPassword(), token,userDetails.getAuthorities());
                return new UserDto(usuario.getUsername(), usuario.getPassword(), token, userDetails.getAuthorities(), idEmpleado);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado");
        }


    }

}

