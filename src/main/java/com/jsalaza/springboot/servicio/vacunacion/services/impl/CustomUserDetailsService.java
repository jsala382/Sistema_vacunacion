package com.jsalaza.springboot.servicio.vacunacion.services.impl;

import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import com.jsalaza.springboot.servicio.vacunacion.repository.IUsuarioDao;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IUsuarioDao userRepository;

    // Inyección de dependencias del repositorio de usuarios
    public CustomUserDetailsService(IUsuarioDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí debes obtener el usuario de la base de datos usando su nombre de usuario
        Usuario userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));


        // Convertir la entidad de usuario a un objeto UserDetails
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole()))
        );
    }
}