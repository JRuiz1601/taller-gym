package co.analisys.clases.controller;

import co.analisys.clases.dto.ClaseDTO;
import co.analisys.clases.dto.ClaseRequest;
import co.analisys.clases.dto.InscripcionRequest;
import co.analisys.clases.model.Clase;
import co.analisys.clases.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clase programarClase(@RequestBody ClaseRequest request) {
        return claseService.programarClase(request);
    }

    @GetMapping
    public List<ClaseDTO> obtenerTodasClases() {
        return claseService.obtenerTodasClases();
    }

    @GetMapping("/{id}")
    public ClaseDTO obtenerClase(@PathVariable Long id) {
        return claseService.obtenerClase(id);
    }

    /** Inscribe un miembro en la clase. El agregado rechaza si ya no hay cupo. */
    @PostMapping("/{id}/inscripciones")
    @ResponseStatus(HttpStatus.CREATED)
    public ClaseDTO inscribirMiembro(@PathVariable Long id, @RequestBody InscripcionRequest request) {
        return claseService.inscribirMiembro(id, request.getMiembroId());
    }

    @DeleteMapping("/{id}/inscripciones/{miembroId}")
    public ClaseDTO cancelarInscripcion(@PathVariable Long id, @PathVariable Long miembroId) {
        return claseService.cancelarInscripcion(id, miembroId);
    }
}
