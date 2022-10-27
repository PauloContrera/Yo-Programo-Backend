/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.Paulo.Repository;

import com.portafolio.Paulo.Entity.Educacion;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
          public Optional<Educacion> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}