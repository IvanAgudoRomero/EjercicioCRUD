package com.example.CrudPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

@Service
public class Servicio {
    private HashMap lista;
    int id;

    public Servicio() {
        lista = new HashMap();
        id = 0;
    }

    public void guardar(Persona p){
        lista.put(id,p);
        id++;
    }

    public void borrar(Integer id){
        lista.remove(id);
    }

    public void actualizar(Integer id, Persona p){
        Persona aux;
        try {
            aux = (Persona) lista.get(id);

            if(p.getNombre()==null){
                p.setNombre(aux.getNombre());
            }
            if(p.getEdad()==-1){
                p.setEdad(aux.getEdad());
            }
            if(p.getPoblacion()==null){
                p.setPoblacion(aux.getPoblacion());
            }

            lista.put(id,p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Persona select(Integer id){
        Persona p = new Persona();
        try {
            p = (Persona) lista.get(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList select(String nombre){
        Persona p = new Persona();
        ArrayList resultado = new ArrayList<Persona>();
        Iterator it = lista.entrySet().iterator();
        while (it.hasNext()){
            p = (Persona) it.next();
            if(p.getNombre().equals(nombre)){
                resultado.add(p.getNombre());
            }
            return resultado;
        }
        return resultado;
    }
}
