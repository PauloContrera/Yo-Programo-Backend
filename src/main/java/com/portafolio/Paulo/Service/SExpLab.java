/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Service;

import com.portafolio.Paulo.Entity.ExpLab;
import com.portafolio.Paulo.Repository.RExpLab;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExpLab {
         @Autowired
     RExpLab rExpLab;
     
     public List<ExpLab> list(){
         return rExpLab.findAll();
     }
     
     public Optional<ExpLab> getOne(int id){
         return rExpLab.findById(id);
     }
     
     public Optional<ExpLab> getByNombreE(String nombre){
         return rExpLab.findByNombre(nombre);
     }
     
     public void save(ExpLab expe){
         rExpLab.save(expe);
     }
     
     public void delete(int id){
         rExpLab.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rExpLab.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rExpLab.existsByNombre(nombre);
     }
}
