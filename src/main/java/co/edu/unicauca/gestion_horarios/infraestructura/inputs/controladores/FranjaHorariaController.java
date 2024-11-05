package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearFranjaHorariaCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.ListarFranjasPorDocenteCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTOPeticion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/franjas")
public class FranjaHorariaController {

    @Autowired
    private CrearFranjaHorariaCasoUso crearFranjaHorariaCasoUso;
    
    @Autowired
    private ListarFranjasPorDocenteCasoUso listarFranjasPorDocenteCasoUso;

    @PostMapping
    public ResponseEntity<?> crearFranjaHoraria(@Valid @RequestBody FranjaHorariaDTOPeticion dto) {
        try {
            FranjaHoraria nuevaFranja = crearFranjaHorariaCasoUso.crearFranjaHoraria(dto);
            return new ResponseEntity<>(nuevaFranja, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/docente/{id}")
    public ResponseEntity<?> listarFranjasPorDocente(
            @PathVariable("id") @Min(value = 1, message = "{id.min}") int docenteId) {
        List<FranjaHoraria> franjas = listarFranjasPorDocenteCasoUso.listarFranjasPorDocente(docenteId);
        return new ResponseEntity<>(franjas, HttpStatus.OK);
    }
}
