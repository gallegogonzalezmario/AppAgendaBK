package es.ieslosmontecillos.AppAgendaBK.services;

import es.ieslosmontecillos.AppAgendaBK.entity.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();

    public Persona save(Persona persona);

    public Persona findbyId(Long id);

    public void delete(Persona persona);
}
