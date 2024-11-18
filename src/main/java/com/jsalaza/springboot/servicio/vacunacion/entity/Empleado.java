package com.jsalaza.springboot.servicio.vacunacion.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idempleado;

    @Column(unique = true)
    private String cedula;
    private String nombres;
    private String apellidos;


    @Column(unique = true)
    private String correo_electronico;
    private LocalDate fechaNacimiento;
    private String Direccion;
    private String telefonoMovil;

    @Enumerated(EnumType.STRING)
    private EstadoVacunacion estadoVacunacion;
    @Enumerated(EnumType.STRING)
    private TipoVacuna tipoVacuna;
    private LocalDate fechaVacunacion;
    private Integer numDosis;

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.idempleado = idempleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public EstadoVacunacion getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(EstadoVacunacion estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public TipoVacuna getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(TipoVacuna tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public LocalDate getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(LocalDate fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public Integer getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(Integer numDosis) {
        this.numDosis = numDosis;
    }

    public enum EstadoVacunacion{
        VACUNADO,
        NO_VACUNADO
    }
    public enum TipoVacuna{
        SPUTNIK,
        ASTRAZENECA,
        PFIZER,
        JOHNSON_JOHNSON

    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    private static final long serialVersionUID=11;
}
