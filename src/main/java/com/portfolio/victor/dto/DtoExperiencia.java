package com.portfolio.victor.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {   
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String fechaExp;
    @NotBlank
    private String imagenExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descripcionExp, String fechaExp, String imagenExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.fechaExp = fechaExp;
        this.imagenExp = imagenExp;
    }  
}