package es.ieslosmontecillos.AppAgendaBK.controller;

import es.ieslosmontecillos.AppAgendaBK.entity.Provincia;
import es.ieslosmontecillos.AppAgendaBK.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value = "/PROVINCIA")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // Genera una lista de provincias
            List<Provincia> list = provinciaService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Solicita un identificador de la tabla provincia
    @GetMapping(value = "/PROVINCIA/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Provincia data = provinciaService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Da de alta un registro de la tabla provincia
    @PostMapping(value = "/PROVINCIA")
    public ResponseEntity<Object> create(@RequestBody Provincia provincia) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Provincia res = provinciaService.save(provincia);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualiza un registro de la tabla provincia
    @PutMapping("/PROVINCIA/{id}")
    public ResponseEntity<Object> update(@RequestBody Provincia provincia,
                                         @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Provincia currentProvincia = provinciaService.findById(id);
            currentProvincia.setNombre(provincia.getNombre());
            currentProvincia.setCodigo(provincia.getCodigo());
            Provincia res = provinciaService.save(currentProvincia);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borra un registro de la tabla
    @DeleteMapping("/PROVINCIA/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Provincia currentProvincia = provinciaService.findById(id);
            provinciaService.delete(currentProvincia);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

