package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio {

    @Autowired
    PersonaRepositorio pr;

    public Servicio() {
    }

    public void guardar(Persona p){
        pr.save(p);
    }

    public void borrar(Integer id){
        pr.deleteById(id);
    }

    public void actualizar(Integer id, Persona p){
        Persona aux;
        try {
            aux = pr.findById(id).orElseThrow(()-> new Exception("Id no encontrada("+id+")"));

            if(p.getNombre()==null){
                p.setNombre(aux.getNombre());
            }
            if(p.getEdad()==-1){
                p.setEdad(aux.getEdad());
            }
            if(p.getPoblacion()==null){
                p.setPoblacion(aux.getPoblacion());
            }

            pr.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Persona select(Integer id){
        Persona p = new Persona();
        try {
            p = pr.findById(id).orElseThrow(()-> new Exception("Id no encontrada("+id+")"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Persona select(String nombre){
        Persona p = new Persona();
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista = (ArrayList<Persona>) pr.findAll();
        for(int i = 0;i<lista.size();i++){
            p = lista.get(i);
            if(p.getNombre().equals(nombre)){
                return p;
            }
        }
        return null;
    }
}
