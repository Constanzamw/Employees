package com.gestion.empleados.models;

// 1ª --> PRIMER PASO GENERO EL MODELO.

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "empleados") //NOMBRE DE LA TABLA EN MI DB

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTADO
    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // genero un constructor
    public Empleado() {

    }

    // GENERO CONTRUCTOR BOTON DERECHO -> SOURCE ACTION
    public Empleado(Long id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // GENERO GETTER Y SETTERS BOTON DERECHO -> SOURCE ACTION
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
