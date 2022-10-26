package com.portafolio.Paulo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExpLab {

    
    @NotBlank
    private String nombre;
    @NotBlank
    private String lugar;
    @NotBlank
    private String desde;
    @NotBlank
    private String hasta;
    @NotBlank
    private String texto;
    @NotBlank
    private String img;

    //Constructores

    public dtoExpLab() {
    }

    public dtoExpLab(String nombre, String lugar, String desde, String hasta, String texto, String img) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.desde = desde;
        this.hasta = hasta;
        this.texto = texto;
        this.img = img;
    }

    

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
}
