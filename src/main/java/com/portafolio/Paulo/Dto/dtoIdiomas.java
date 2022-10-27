/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoIdiomas {

    @NotBlank
    private String nombre;
    @NotBlank
    private int valor;

    //Constructores
    public dtoIdiomas() {
    }

    public dtoIdiomas(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
