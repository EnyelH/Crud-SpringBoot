package com.example.crud.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/personas")
public class PersonaControlller {

    private final PersonaService personaService;

    @Autowired
    public PersonaControlller(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return this.personaService.getPersonas();
    }

    @PostMapping
    public ResponseEntity<Object> registrarPersona(@RequestBody Persona persona){
        return this.personaService.newPersona(persona);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarPersona(@RequestBody Persona persona){
        return this.personaService.newPersona(persona);
    }

    @DeleteMapping(path = "{personaId}")
    public ResponseEntity<Object> eliminarPersona(@PathVariable("personaId") Long id){
        return this.personaService.deletePersona(id);
    }

}
