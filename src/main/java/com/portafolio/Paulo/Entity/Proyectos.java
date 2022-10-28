/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String texto;
    private String img;
    private String lenguajes;

    private String url;
    private String github;
    private String video;
    
    private boolean habilitaVideo;
    private boolean habilitaUrl;
    private boolean habilitaGithub;
    private boolean habilitalenguajes;

    //Constructores
    public Proyectos() {
    }

    public Proyectos(String nombre, String texto, String img, String lenguajes, String url, String github, String video, boolean habilitaVideo, boolean habilitaUrl, boolean habilitaGithub, boolean habilitalenguajes) {
        this.nombre = nombre;
        this.texto = texto;
        this.img = img;
        this.lenguajes = lenguajes;
        this.url = url;
        this.github = github;
        this.video = video;
        this.habilitaVideo = habilitaVideo;
        this.habilitaUrl = habilitaUrl;
        this.habilitaGithub = habilitaGithub;
        this.habilitalenguajes = habilitalenguajes;
    }

    

    

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isHabilitaGithub() {
        return habilitaGithub;
    }

    public void setHabilitaGithub(boolean habilitaGithub) {
        this.habilitaGithub = habilitaGithub;
    }

    public boolean isHabilitalenguajes() {
        return habilitalenguajes;
    }

    public void setHabilitalenguajes(boolean habilitalenguajes) {
        this.habilitalenguajes = habilitalenguajes;
    }

   
    

}
