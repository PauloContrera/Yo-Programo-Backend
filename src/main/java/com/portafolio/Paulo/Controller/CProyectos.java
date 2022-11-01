/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Controller;

import com.portafolio.Paulo.Dto.dtoProyectos;
import com.portafolio.Paulo.Entity.Proyectos;
import com.portafolio.Paulo.Security.Controller.Mensaje;
import com.portafolio.Paulo.Service.SProyectos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang3.StringUtils;


@RestController
@RequestMapping("/Proyectos")
@CrossOrigin(origins = "https://yo-programo-paulo.web.app")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/individual/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos expLab = sProyectos.getOne(id).get();
        return new ResponseEntity(expLab, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
@PostMapping("/crear")
public ResponseEntity<?> create(@RequestBody dtoProyectos dtoadm){      
    if(StringUtils.isBlank(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    /* Que no se agrega un acerca existente
    if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("Esa Acerca de mi existe"), HttpStatus.BAD_REQUEST);
    */
    Proyectos expLab = new Proyectos(dtoadm.getNombre(),dtoadm.getTexto(),dtoadm.getImg(),dtoadm.getLenguajes(),dtoadm.getUrl(),dtoadm.getGithub(),dtoadm.getVideo(),dtoadm.isHabilitaUrl(),dtoadm.isHabilitaGithub(),dtoadm.isHabilitaVideo(), dtoadm.isHabilitalenguajes());
    sProyectos.save(expLab);
    
    return new ResponseEntity(new Mensaje("Acerca de mi agregada"), HttpStatus.OK);
}
    
   @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoadm){
        //Validamos si existe el ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        /* vALIDAR QUE NO EXITA OTRA
        if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()) && sAcercaDeMi.getByNombreE(dtoadm.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa acercaDeMi ya existe"), HttpStatus.BAD_REQUEST);
        */
        //No puede estar vacio
        if(StringUtils.isBlank(dtoadm.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos expLab = sProyectos.getOne(id).get();
        expLab.setNombre(dtoadm.getNombre());
        expLab.setTexto(dtoadm.getTexto());
        expLab.setImg(dtoadm.getImg());
        expLab.setLenguajes(dtoadm.getLenguajes());
        expLab.setUrl(dtoadm.getUrl());
        expLab.setGithub(dtoadm.getGithub());
        expLab.setVideo(dtoadm.getVideo());
        expLab.setHabilitaUrl(dtoadm.isHabilitaUrl());
        expLab.setHabilitaGithub(dtoadm.isHabilitaGithub());
        expLab.setHabilitaVideo(dtoadm.isHabilitaVideo());
        expLab.setHabilitalenguajes(dtoadm.isHabilitalenguajes());
        sProyectos.save(expLab);
        return new ResponseEntity(new Mensaje("Acerca de mi actualizado"), HttpStatus.OK);
             
    }
}
