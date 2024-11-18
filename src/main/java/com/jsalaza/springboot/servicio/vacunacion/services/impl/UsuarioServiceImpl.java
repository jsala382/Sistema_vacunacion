package com.jsalaza.springboot.servicio.vacunacion.services.impl;

import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import com.jsalaza.springboot.servicio.vacunacion.repository.IUsuarioDao;
import com.jsalaza.springboot.servicio.vacunacion.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);

    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }
}

