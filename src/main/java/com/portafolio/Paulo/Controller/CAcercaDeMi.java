/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Controller;

import com.portafolio.Paulo.Dto.dtoAcercaDeMi;
import com.portafolio.Paulo.Entity.AcercaDeMi;
import com.portafolio.Paulo.Security.Controller.Mensaje;
import com.portafolio.Paulo.Service.SAcercaDeMi;

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
@RequestMapping("/Acerca")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcercaDeMi {
    @Autowired
    SAcercaDeMi sAcercaDeMi;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDeMi>> list(){
        List<AcercaDeMi> list = sAcercaDeMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/individual/{id}")
    public ResponseEntity<AcercaDeMi> getById(@PathVariable("id") int id){
        if(!sAcercaDeMi.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AcercaDeMi acercaDeMi = sAcercaDeMi.getOne(id).get();
        return new ResponseEntity(acercaDeMi, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAcercaDeMi.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sAcercaDeMi.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
@PostMapping("/crear")
public ResponseEntity<?> create(@RequestBody dtoAcercaDeMi dtoadm){      
    if(StringUtils.isBlank(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    /* Que no se agrega un acerca existente
    if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("Esa Acerca de mi existe"), HttpStatus.BAD_REQUEST);
    */
    AcercaDeMi acercaDeMi = new AcercaDeMi(dtoadm.getNombre(), dtoadm.getTexto(), dtoadm.getTexto2(), dtoadm.getImg());
    sAcercaDeMi.save(acercaDeMi);
    
    return new ResponseEntity(new Mensaje("Acerca de mi agregada"), HttpStatus.OK);
}
    
   @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDeMi dtoadm){
        //Validamos si existe el ID
        if(!sAcercaDeMi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        /* vALIDAR QUE NO EXITA OTRA
        if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()) && sAcercaDeMi.getByNombreE(dtoadm.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa acercaDeMi ya existe"), HttpStatus.BAD_REQUEST);
        */
        //No puede estar vacio
        if(StringUtils.isBlank(dtoadm.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        AcercaDeMi acercaDeMi = sAcercaDeMi.getOne(id).get();
        acercaDeMi.setNombre(dtoadm.getNombre());
        acercaDeMi.setTexto((dtoadm.getTexto()));
        acercaDeMi.setTexto2((dtoadm.getTexto2()));
        acercaDeMi.setImg((dtoadm.getImg()));
        
        sAcercaDeMi.save(acercaDeMi);
        return new ResponseEntity(new Mensaje("Acerca de mi actualizado"), HttpStatus.OK);
             
    }
}

