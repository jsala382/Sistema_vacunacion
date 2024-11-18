package com.jsalaza.springboot.servicio.vacunacion.services;

import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;
import java.util.List;

public interface IEmpleadoService {
    public List<Empleado>findAll();
    public Empleado findById(Integer id);
    public Empleado save(Empleado empleado);
    public void delete(Integer id);
}
