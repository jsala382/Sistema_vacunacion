package com.jsalaza.springboot.servicio.vacunacion.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idusuario;
    private String username;
    private String password;
    private  String role;



    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                "role='" + role + '\'' +
                '}';
    }


    private static final long serialVersionUID=11;


}
