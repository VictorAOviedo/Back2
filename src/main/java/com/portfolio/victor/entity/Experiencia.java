package com.portfolio.victor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;
    private String fechaExp;
    private String imagenExp;

    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripcionExp, String fechaExp, String imagenExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.fechaExp = fechaExp;
        this.imagenExp = imagenExp;
    }   
}
