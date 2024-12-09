package com.jsalaza.springboot.servicio.vacunacion.controllers;

import com.jsalaza.springboot.servicio.vacunacion.entity.Empleado;
import com.jsalaza.springboot.servicio.vacunacion.entity.Usuario;
import com.jsalaza.springboot.servicio.vacunacion.repository.IEmpleadoDao;
import com.jsalaza.springboot.servicio.vacunacion.repository.IUsuarioDao;
import com.jsalaza.springboot.servicio.vacunacion.services.impl.EmpleadoServiceImpl;
import com.jsalaza.springboot.servicio.vacunacion.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class VacunacionRestController {

    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IEmpleadoDao empleadoDao;


    //Metodos para los empleados
    @GetMapping("/empleados")
    public List<Empleado> getEmpleado() {
        return empleadoService.findAll();
    }

    @GetMapping("/empleados/{idempleado}")
    public Empleado showEmployes(@PathVariable Integer idempleado) {
        return empleadoService.findById(idempleado);
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.save(empleado);
    }


    @PutMapping("/empleados/{idempleado}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado updateEmpleado(@RequestBody Empleado empleado, @PathVariable Integer idempleado) {
        Empleado empleadoActual = empleadoService.findById(idempleado);
        empleadoActual.setId_empleado(empleado.getIdempleado());
        empleadoActual.setNombres(empleado.getNombres());
        empleadoActual.setApellidos(empleado.getApellidos());
        empleadoActual.setCorreo_electronico(empleado.getCorreo_electronico());
        empleadoActual.setFechaNacimiento(empleado.getFecha_nacimiento());
        empleadoActual.setDireccion(empleado.getDireccion());
        empleadoActual.setTelefono_movil(empleado.getTelefono_movil());
        empleadoActual.setEstado_vacunacion(empleado.getEstado_vacunacion());
        empleadoActual.setTipo_vacuna(empleado.getTipo_vacuna());
        empleadoActual.setFecha_vacunacion(empleado.getFecha_vacunacion());
        empleadoActual.setNum_dosis(empleado.getNum_dosis());
        return empleadoService.save(empleadoActual);
    }

    @DeleteMapping("/empleados/{idempleado}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer idempleado) {
        empleadoService.delete(idempleado);
    }


    @GetMapping("/empleados/filtros")
    public List<Empleado> obtenerEmpleadosFiltrados(
            @RequestParam(required = false) Empleado.EstadoVacunacion estado,
            @RequestParam(required = false) Empleado.TipoVacuna tipo,
            @RequestParam(required = false) LocalDate fechaInicio,
            @RequestParam(required = false) LocalDate fechaFin) {

        return empleadoService.filterEmpelados(estado, tipo, fechaInicio, fechaFin);
    }

    //Metodos para los usuarios
    //Metodo GET para obtener
    @GetMapping("/usuarios")
    public List<Usuario> getUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{idusuario}")
    public Usuario showUser(@PathVariable Integer idusuario) {
        return usuarioService.findById(idusuario);
    }

    //Metodo POst para guardar
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }


    //Metodo Put para actualizar
    @PutMapping("/usuarios/{idusuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer idusuario) {
        Usuario usuarioActual = usuarioService.findById(idusuario);
        usuarioActual.setIdusuario(usuario.getIdusuario());
        usuarioActual.setUsername(usuario.getUsername());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setRole(usuario.getRole());
        return usuarioService.save(usuarioActual);
    }

    //Metodo delete para borrar
    @DeleteMapping("/usuarios/{idusuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Integer idusuario) {
        usuarioService.delete(idusuario);
    }
}

