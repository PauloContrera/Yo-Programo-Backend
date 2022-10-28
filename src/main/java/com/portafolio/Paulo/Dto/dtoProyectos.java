/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Dto;


import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String texto;
    @NotBlank
    private String img;
    @NotBlank
    private String lenguajes;
    
    @NotBlank
    private String url;
    @NotBlank
    private String github;
    @NotBlank
    private String video;
    @NotBlank
    
    private boolean habilitaVideo;
    @NotBlank
    private boolean habilitaUrl;
    @NotBlank
    private boolean habilitalenguajes;;
    @NotBlank
    private boolean habilitaGithub;
    
    
    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String texto, String img, String lenguajes, String url, String github, String video, boolean habilitaVideo, boolean habilitaUrl, boolean habilitalenguajes, boolean habilitaGithub) {
        this.nombre = nombre;
        this.texto = texto;
        this.img = img;
        this.lenguajes = lenguajes;
        this.url = url;
        this.github = github;
        this.video = video;
        this.habilitaVideo = habilitaVideo;
        this.habilitaUrl = habilitaUrl;
        this.habilitalenguajes = habilitalenguajes;
        this.habilitaGithub = habilitaGithub;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public boolean isHabilitaVideo() {
        return habilitaVideo;
    }

    public void setHabilitaVideo(boolean habilitaVideo) {
        this.habilitaVideo = habilitaVideo;
    }

    public boolean isHabilitaUrl() {
        return habilitaUrl;
    }

    public void setHabilitaUrl(boolean habilitaUrl) {
        this.habilitaUrl = habilitaUrl;
    }

    public boolean isHabilitalenguajes() {
        return habilitalenguajes;
    }

    public void setHabilitalenguajes(boolean habilitalenguajes) {
        this.habilitalenguajes = habilitalenguajes;
    }

    public boolean isHabilitaGithub() {
        return habilitaGithub;
    }

    public void setHabilitaGithub(boolean habilitaGithub) {
        this.habilitaGithub = habilitaGithub;
    }

    
    
}
