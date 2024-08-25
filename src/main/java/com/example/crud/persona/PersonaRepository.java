package com.example.crud.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    //@Query("SELECT * FROM Persona p WHERE p.name= ?")
    Optional<Persona> findPersonaByName(String name);
}
