package com.portfolio.victor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkills;
    private String imagenSkills;
    private String porcentajeSkills;
    private String colorPrimarioSkills;
    private String colorSecundarioSkills;

    public Skills() {
    }

    public Skills(String nombreSkills, String imagenSkills, String porcentajeSkills, String colorPrimarioSkills, String colorSecundarioSkills) {
        this.nombreSkills = nombreSkills;
        this.imagenSkills = imagenSkills;
        this.porcentajeSkills = porcentajeSkills;
        this.colorPrimarioSkills = colorPrimarioSkills;
        this.colorSecundarioSkills = colorSecundarioSkills;
    }  
}
