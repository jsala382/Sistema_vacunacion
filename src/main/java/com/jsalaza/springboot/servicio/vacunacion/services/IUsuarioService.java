package com.jsalaza.springboot.servicio.vacunacion.services;

import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public Usuario save(Usuario usuario);

    public void delete(Integer id);


}
