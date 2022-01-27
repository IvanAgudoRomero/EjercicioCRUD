package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Insert {

    @Autowired
    Servicio s;

    @PostMapping("/persona")
    public void addPersona(@RequestBody Persona p){
        s.guardar(p);
    }
}
