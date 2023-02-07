package com.portfolio.victor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String descripcion;
    private String imagen;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String descripcion, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }  
}
