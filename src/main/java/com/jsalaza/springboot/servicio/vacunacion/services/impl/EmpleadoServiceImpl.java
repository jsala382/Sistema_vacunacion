package com.jsalaza.springboot.servicio.vacunacion.services.impl;

import com.jsalaza.springboot.servicio.vacunacion.repository.IEmpleadoDao;
import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;
import com.jsalaza.springboot.servicio.vacunacion.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    @Autowired
    private IEmpleadoDao empleadoDao;
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public Empleado findById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }
    @Override
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    public void delete(Integer id) {
        empleadoDao.deleteById(id);
    }
}
