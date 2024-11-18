package com.jsalaza.springboot.servicio.vacunacion.repository;

import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
