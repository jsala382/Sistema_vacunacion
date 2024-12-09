package com.jsalaza.springboot.servicio.vacunacion.services.impl;

import com.jsalaza.springboot.servicio.vacunacion.repository.IEmpleadoDao;
import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;
import com.jsalaza.springboot.servicio.vacunacion.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Empleado> filterEmpelados(Empleado.EstadoVacunacion estado_vacunacion, Empleado.TipoVacuna tipo_vacuna, LocalDate fecha_inicio, LocalDate fecha_final) {
        List<Empleado> empleadoList= (List<Empleado>) empleadoDao.findAll();
        return empleadoList.stream()
                .filter(empleado -> estado_vacunacion==null || empleado.getEstado_vacunacion()==estado_vacunacion)
                .filter(empleado -> tipo_vacuna==null || empleado.getTipo_vacuna()==tipo_vacuna)
                .filter(empleado -> (fecha_inicio== null || !empleado.getFecha_vacunacion().isBefore(fecha_inicio)) &&
                                    (fecha_final== null || !empleado.getFecha_vacunacion().isAfter(fecha_final)))
                .collect(Collectors.toList());
    }
}
