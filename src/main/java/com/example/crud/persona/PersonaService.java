package com.example.crud.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    HashMap<String, Object> datos;

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    };

    @GetMapping
    public List<Persona> getPersonas(){
        return this.personaRepository.findAll();
    }

    public ResponseEntity<Object> newPersona(Persona persona){
        Optional<Persona> respuesta = personaRepository.findPersonaByName(persona.getName());

        datos= new HashMap<>();

        if (respuesta.isPresent() && persona.getId() == null){

            datos.put("error", true);
            datos.put("message", "Ya existe la persona");

            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("message", "Se guardo con exito");
        if (persona.getId()!=null){
            datos.put("message", "Se actualizo con exito");
        }
        personaRepository.save(persona);

        datos.put("datos", persona);
        datos.put("message", "Se guardo con exito");

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deletePersona(Long id){

        boolean existe = this.personaRepository.existsById(id);

        datos= new HashMap<>();

        if (!existe){

            datos.put("error", true);
            datos.put("message", "No existe una persona con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        personaRepository.deleteById(id);
        datos.put("message", "Persona eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
