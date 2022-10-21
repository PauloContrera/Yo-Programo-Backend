
package com.portafolio.Paulo.Service;

import com.portafolio.Paulo.Entity.Persona;
import com.portafolio.Paulo.Interface.IPersonasService;
import com.portafolio.Paulo.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImpPersonaService implements IPersonasService{

    @Autowired IPersonaRepository ipersonaRepository;
    
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletPersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona= ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
    
}
