package co.analisys.entrenadores.controller;

import co.analisys.entrenadores.dto.EntrenadorRequest;
import co.analisys.entrenadores.model.Entrenador;
import co.analisys.entrenadores.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrenador agregarEntrenador(@RequestBody EntrenadorRequest request) {
        return entrenadorService.agregarEntrenador(request);
    }

    @GetMapping
    public List<Entrenador> obtenerTodosEntrenadores() {
        return entrenadorService.obtenerTodosEntrenadores();
    }

    // Consultado por clases-service para enriquecer sus clases con los datos
    // del entrenador sin compartir la base de datos entre ambos contextos.
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable Long id) {
        return entrenadorService.obtenerEntrenadorPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
