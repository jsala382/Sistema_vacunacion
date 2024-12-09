package com.jsalaza.springboot.servicio.vacunacion.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Empleado implements Serializable {

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idempleado;

    @Column(unique = true)
    private String cedula;
    private String nombres;
    private String apellidos;


    @Column(unique = true)
    private String correo_electronico;
    private LocalDate fecha_nacimiento;
    private String Direccion;
    private String telefono_movil;
    @Enumerated(EnumType.STRING)
    private EstadoVacunacion estado_vacunacion;
    @Enumerated(EnumType.STRING)
    private TipoVacuna tipo_vacuna;
    private LocalDate fecha_vacunacion;
    private Integer num_dosis;

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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }



    public String getTelefono_movil() {
        return telefono_movil;
    }
    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }



    public TipoVacuna getTipo_vacuna() {
        return tipo_vacuna;
    }

    public void setTipo_vacuna(TipoVacuna tipo_vacuna) {
        this.tipo_vacuna= tipo_vacuna;
    }

    public EstadoVacunacion getEstado_vacunacion() {
        return estado_vacunacion;
    }

    public void setEstado_vacunacion(EstadoVacunacion estado_vacunacion) {
        this.estado_vacunacion = estado_vacunacion;
    }







    public Integer getNum_dosis() {
        return num_dosis;
    }

    public void setNum_dosis(Integer num_dosis) {
        this.num_dosis = num_dosis;
    }



    public enum EstadoVacunacion{
        VACUNADO("Vacunado"),
        NO_VACUNADO("No Vacunado");

        EstadoVacunacion(String vacunado) {
        }
    }
    public enum TipoVacuna{
        SPUTNIK("Sputnik"),
        ASTRAZENECA("Astrazeneca"),
        PFIZER("Pfizer"),
        JOHNSON_JOHNSON("Johnson_Johnsson");

        TipoVacuna(String sputnik) {
        }
    }
    public LocalDate getFecha_vacunacion() {
        return fecha_vacunacion;
    }

    public void setFecha_vacunacion(LocalDate fecha_vacunacion) {
        this.fecha_vacunacion = fecha_vacunacion;
    }


    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    private static final long serialVersionUID=11;
}
