/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Dto;


import javax.validation.constraints.NotBlank;


public class dtoHabilidades {
    
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String img;

    //Constructores

    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombre, String img) {
        this.nombre = nombre;
        this.img = img;
    }

    

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
}
