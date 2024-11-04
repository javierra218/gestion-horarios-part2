package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearAsignaturaCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.AsignaturaDTOPeticion;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private CrearAsignaturaCasoUso crearAsignaturaCasoUso;

    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@Valid @RequestBody AsignaturaDTOPeticion dto) {
        Asignatura nuevaAsignatura = crearAsignaturaCasoUso.crearAsignatura(dto);
        return new ResponseEntity<>(nuevaAsignatura, HttpStatus.CREATED);
    }
}