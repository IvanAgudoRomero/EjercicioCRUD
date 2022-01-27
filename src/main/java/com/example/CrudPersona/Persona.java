package com.example.CrudPersona;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Persona {
    @Id
    @GeneratedValue
    Integer id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private int edad;

    @Getter
    @Setter
    private String poblacion;


}
