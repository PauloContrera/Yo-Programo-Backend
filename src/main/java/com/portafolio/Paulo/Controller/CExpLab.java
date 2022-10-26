package com.portafolio.Paulo.Controller;

import com.portafolio.Paulo.Dto.dtoExpLab;
import com.portafolio.Paulo.Entity.ExpLab;
import com.portafolio.Paulo.Security.Controller.Mensaje;
import com.portafolio.Paulo.Service.SExpLab;

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
@RequestMapping("/ExpLab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExpLab {
     @Autowired
    SExpLab sExpLab;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ExpLab>> list(){
        List<ExpLab> list = sExpLab.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/individual/{id}")
    public ResponseEntity<ExpLab> getById(@PathVariable("id") int id){
        if(!sExpLab.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExpLab expLab = sExpLab.getOne(id).get();
        return new ResponseEntity(expLab, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExpLab.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExpLab.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
@PostMapping("/crear")
public ResponseEntity<?> create(@RequestBody dtoExpLab dtoadm){      
    if(StringUtils.isBlank(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    /* Que no se agrega un acerca existente
    if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()))
        return new ResponseEntity(new Mensaje("Esa Acerca de mi existe"), HttpStatus.BAD_REQUEST);
    */
    ExpLab expLab = new ExpLab(dtoadm.getNombre(),dtoadm.getLugar(),dtoadm.getDesde(),dtoadm.getHasta(),dtoadm.getTexto(),dtoadm.getImg());
    sExpLab.save(expLab);
    
    return new ResponseEntity(new Mensaje("Acerca de mi agregada"), HttpStatus.OK);
}
    
   @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExpLab dtoadm){
        //Validamos si existe el ID
        if(!sExpLab.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        /* vALIDAR QUE NO EXITA OTRA
        if(sAcercaDeMi.existsByNombre(dtoadm.getNombre()) && sAcercaDeMi.getByNombreE(dtoadm.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa acercaDeMi ya existe"), HttpStatus.BAD_REQUEST);
        */
        //No puede estar vacio
        if(StringUtils.isBlank(dtoadm.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExpLab expLab = sExpLab.getOne(id).get();
        expLab.setNombre(dtoadm.getNombre());
        expLab.setLugar(dtoadm.getLugar());
        expLab.setDesde(dtoadm.getDesde());
        expLab.setTexto(dtoadm.getTexto());
        expLab.setImg(dtoadm.getImg());
        sExpLab.save(expLab);
        return new ResponseEntity(new Mensaje("Acerca de mi actualizado"), HttpStatus.OK);
             
    }
}
