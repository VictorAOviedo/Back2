package com.portfolio.victor.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    private String urlPro;
    private String imgPro;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombrePro, String descripcionPro, String urlPro, String imgPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.urlPro = urlPro;
        this.imgPro = imgPro;
    }  
}
