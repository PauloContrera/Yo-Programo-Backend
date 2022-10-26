/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.Paulo.Service;


import com.portafolio.Paulo.Entity.AcercaDeMi;
import com.portafolio.Paulo.Repository.RAcercaDeMi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SAcercaDeMi {
         @Autowired
     RAcercaDeMi rAcercaDeMi;
     
     public List<AcercaDeMi> list(){
         return rAcercaDeMi.findAll();
     }
     
     public Optional<AcercaDeMi> getOne(int id){
         return rAcercaDeMi.findById(id);
     }
     
     public Optional<AcercaDeMi> getByNombreE(String nombre){
         return rAcercaDeMi.findByNombre(nombre);
     }
     
     public void save(AcercaDeMi expe){
         rAcercaDeMi.save(expe);
     }
     
     public void delete(int id){
         rAcercaDeMi.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rAcercaDeMi.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rAcercaDeMi.existsByNombre(nombre);
     }
}
