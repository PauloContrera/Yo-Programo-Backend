package com.portafolio.Paulo.Repository;

import com.portafolio.Paulo.Entity.AcercaDeMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RAcercaDeMi extends JpaRepository<AcercaDeMi, Integer>{
          public Optional<AcercaDeMi> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
