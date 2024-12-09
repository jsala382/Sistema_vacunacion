package com.jsalaza.springboot.servicio.vacunacion.services;

import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;

import java.time.LocalDate;
import java.util.List;

public interface IEmpleadoService {
    public List<Empleado>findAll();
    public Empleado findById(Integer id);
    public Empleado save(Empleado empleado);
    public void delete(Integer id);
    public List<Empleado> filterEmpelados(Empleado.EstadoVacunacion estado_vacunacion, Empleado.TipoVacuna tipo_vacuna, LocalDate fecha_inicion, LocalDate fecha_final);
}
