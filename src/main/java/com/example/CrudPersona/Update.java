package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Update {

    @Autowired
    Servicio s;

    @PutMapping("/persona/{id}")
    public void update(@RequestBody Persona p, @PathVariable Integer id){
        s.actualizar(id, p);
    }
}
