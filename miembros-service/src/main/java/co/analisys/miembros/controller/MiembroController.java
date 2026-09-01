package co.analisys.miembros.controller;

import co.analisys.miembros.dto.MiembroRequest;
import co.analisys.miembros.model.Miembro;
import co.analisys.miembros.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {
    @Autowired
    private MiembroService miembroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Miembro registrarMiembro(@RequestBody MiembroRequest request) {
        return miembroService.registrarMiembro(request);
    }

    @GetMapping
    public List<Miembro> obtenerTodosMiembros() {
        return miembroService.obtenerTodosMiembros();
    }

    @GetMapping("/{id}")
    public Miembro obtenerMiembro(@PathVariable Long id) {
        return miembroService.obtenerMiembro(id);
    }
}
