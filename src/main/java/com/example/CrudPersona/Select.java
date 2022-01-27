package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Select {

    @Autowired
    Servicio s;

    @GetMapping("/persona/{id}")
    public Persona consultarID(@PathVariable Integer id){
        Persona p;
        p = s.select(id);
        return p;
    }

    @GetMapping("/persona/nombre/{nombre}")
    public Persona consultarNombre(@PathVariable String nombre){
        Persona p = null;
        p=s.select(nombre);
        if(p==null){
            p.setNombre("");
            p.setEdad(-1);
            p.setPoblacion("");
        }else{
            return p;
        }
        return p;
    }
}
