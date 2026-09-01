package co.analisys.equipos.controller;

import co.analisys.equipos.dto.AjusteInventarioRequest;
import co.analisys.equipos.dto.EquipoRequest;
import co.analisys.equipos.model.Equipo;
import co.analisys.equipos.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo agregarEquipo(@RequestBody EquipoRequest request) {
        return equipoService.agregarEquipo(request);
    }

    @GetMapping
    public List<Equipo> obtenerTodosEquipos() {
        return equipoService.obtenerTodosEquipos();
    }

    @GetMapping("/{id}")
    public Equipo obtenerEquipo(@PathVariable Long id) {
        return equipoService.obtenerEquipo(id);
    }

    /** Gestion del inventario: ajuste positivo ingresa unidades, negativo las retira. */
    @PatchMapping("/{id}/inventario")
    public Equipo ajustarInventario(@PathVariable Long id, @RequestBody AjusteInventarioRequest request) {
        return equipoService.ajustarInventario(id, request.getAjuste());
    }
}
