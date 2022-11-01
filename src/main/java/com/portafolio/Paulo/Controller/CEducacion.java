/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Controller;


import com.portafolio.Paulo.Dto.dtoEducacion;
import com.portafolio.Paulo.Entity.Educacion;
import com.portafolio.Paulo.Security.Controller.Mensaje;
import com.portafolio.Paulo.Service.SEducacion;

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
@RequestMapping("/Educacion")
@CrossOrigin(origins = "https://yo-programo-paulo.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/individual/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion expLab = sEducacion.getOne(id).get();
        return new ResponseEntity(expLab, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
@PostMapping("/crear")
public ResponseEntity<?> create(@RequestBody dtoEducacion dtoadm){      
    if(StringUtils.isBlank(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    /* Que no se agrega un acerca existente
    if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("Esa Acerca de mi existe"), HttpStatus.BAD_REQUEST);
    */
    Educacion expLab = new Educacion(dtoadm.getNombre(),dtoadm.getLugar(),dtoadm.getDesde(),dtoadm.getHasta(),dtoadm.getTexto(),dtoadm.getImg());
    sEducacion.save(expLab);
    
    return new ResponseEntity(new Mensaje("Acerca de mi agregada"), HttpStatus.OK);
}
    
   @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoadm){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        /* vALIDAR QUE NO EXITA OTRA
        if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()) && sAcercaDeMi.getByNombreE(dtoadm.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa acercaDeMi ya existe"), HttpStatus.BAD_REQUEST);
        */
        //No puede estar vacio
        if(StringUtils.isBlank(dtoadm.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion expLab = sEducacion.getOne(id).get();
        expLab.setNombre(dtoadm.getNombre());
        expLab.setLugar(dtoadm.getLugar());
        expLab.setDesde(dtoadm.getDesde());
        expLab.setTexto(dtoadm.getTexto());
        expLab.setImg(dtoadm.getImg());
        sEducacion.save(expLab);
        return new ResponseEntity(new Mensaje("Acerca de mi actualizado"), HttpStatus.OK);
             
    }
}
