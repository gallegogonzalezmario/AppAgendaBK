package es.ieslosmontecillos.AppAgendaBK.controller;


import es.ieslosmontecillos.AppAgendaBK.entity.Persona;
import es.ieslosmontecillos.AppAgendaBK.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping(value = "/PERSONA")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // Genera una lista de personas
            List<Persona> list = personaService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception err) {
            map.put("error", err.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Solicita un identificador de la tabla persona
    @GetMapping(value = "/PERSONA/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Persona data = personaService.findbyId(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception err) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", err.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Da de alta un registro de la tabla persona
    @PostMapping(value = "/PERSONA")
    public ResponseEntity<Object> create(@RequestBody Persona persona) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Persona res = personaService.save(persona);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception err) {
            map.put("error", err.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualiza un registro de la tabla
    @PutMapping("/PERSONA/{id}")
    public ResponseEntity<Object> update(@RequestBody Persona persona, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Persona currentPersona = personaService.findbyId(id);
            currentPersona.setNombre(persona.getNombre());
            currentPersona.setApellidos(persona.getApellidos());
            currentPersona.setTelefono(persona.getTelefono());
            currentPersona.setEmail(persona.getEmail());
            currentPersona.setProvincia(persona.getProvincia());
            currentPersona.setFechaNac(persona.getFechaNac());
            currentPersona.setNumHijos(persona.getNumHijos());
            currentPersona.setEstadoCivil(persona.getEstadoCivil());
            currentPersona.setSalario(persona.getSalario());
            currentPersona.setJubilado(persona.getJubilado());
            currentPersona.setFoto(persona.getFoto());

            Persona res = personaService.save(currentPersona);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception err) {
            map.put("error", err.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borra un registro de la tabla
    @DeleteMapping("/PERSONA/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Persona currentProvincia = personaService.findbyId(id);
            personaService.delete(currentProvincia);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
