package com.jsalaza.springboot.servicio.vacunacion.repository;

import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado, Integer> {

}
