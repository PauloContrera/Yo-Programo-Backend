/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcercaDeMi {

    @NotBlank
    private String nombre;
    @NotBlank
    private String texto;
    @NotBlank
    private String texto2;
    @NotBlank
    private String img;

    //Constructores
    public dtoAcercaDeMi() {
    }

    public dtoAcercaDeMi(String nombre, String texto, String texto2, String img) {
        this.nombre = nombre;
        this.texto = texto;
        this.texto2 = texto2;
        this.img = img;
    }

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
