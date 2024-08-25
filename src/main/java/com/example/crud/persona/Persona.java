package com.example.crud.persona;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Table
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String sexo;

    private LocalDate fechaNcimiento;

    @Transient
    private int edad;

    public Persona() {
    }

    public Persona(Long id, String name, String sexo, LocalDate fechaNcimiento ) {
        this.id = id;
        this.name = name;
        this.sexo = sexo;
        this.fechaNcimiento = fechaNcimiento;
    }

    public Persona(String name, String sexo, LocalDate fechaNcimiento) {
        this.name = name;
        this.sexo = sexo;
        this.fechaNcimiento = fechaNcimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEdad() {
        return Period.between(this.fechaNcimiento, LocalDate.now()).getYears();
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNcimiento() {
        return fechaNcimiento;
    }

    public void setFechaNcimiento(LocalDate fechaNcimiento) {
        this.fechaNcimiento = fechaNcimiento;
    }
}
