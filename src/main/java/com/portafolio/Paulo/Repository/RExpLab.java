/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.Paulo.Repository;


import com.portafolio.Paulo.Entity.ExpLab;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
@Repository
public interface RExpLab extends JpaRepository<ExpLab, Integer>{
          public Optional<ExpLab> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
