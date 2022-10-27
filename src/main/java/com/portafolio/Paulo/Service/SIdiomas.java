/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Service;

import com.portafolio.Paulo.Entity.Idiomas;
import com.portafolio.Paulo.Repository.RIdiomas;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdiomas {
    @Autowired
     RIdiomas rIdiomas;
     
     public List<Idiomas> list(){
         return rIdiomas.findAll();
     }
     
     public Optional<Idiomas> getOne(int id){
         return rIdiomas.findById(id);
     }
     
     public Optional<Idiomas> getByNombreE(String nombre){
         return rIdiomas.findByNombre(nombre);
     }
     
     public void save(Idiomas expe){
         rIdiomas.save(expe);
     }
     
     public void delete(int id){
         rIdiomas.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rIdiomas.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rIdiomas.existsByNombre(nombre);
     }
}
