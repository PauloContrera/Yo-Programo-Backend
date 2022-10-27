/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Service;

import com.portafolio.Paulo.Entity.Habilidades;
import com.portafolio.Paulo.Repository.RHabilidades;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    @Autowired
     RHabilidades rHabilidades;
     
     public List<Habilidades> list(){
         return rHabilidades.findAll();
     }
     
     public Optional<Habilidades> getOne(int id){
         return rHabilidades.findById(id);
     }
     
     public Optional<Habilidades> getByNombreE(String nombre){
         return rHabilidades.findByNombre(nombre);
     }
     
     public void save(Habilidades expe){
         rHabilidades.save(expe);
     }
     
     public void delete(int id){
         rHabilidades.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rHabilidades.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rHabilidades.existsByNombre(nombre);
     }
}
