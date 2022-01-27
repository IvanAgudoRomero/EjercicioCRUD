package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Delete {

    @Autowired
    Servicio s;

    @DeleteMapping("/persona/{id}")
    public void addPersona(@PathVariable Integer id){
        s.borrar(id);
    }
}
