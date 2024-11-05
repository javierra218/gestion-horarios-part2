package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearAsignaturaCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.AsignaturaDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers.AsignaturaMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private CrearAsignaturaCasoUso crearAsignaturaCasoUso;

    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@Valid @RequestBody AsignaturaDTOPeticion dto) {
        // Mapeo usando AsignaturaMapper
        Asignatura asignatura = AsignaturaMapper.toEntity(dto);
        
        // Crear la asignatura en el caso de uso
        Asignatura nuevaAsignatura = crearAsignaturaCasoUso.crearAsignatura(asignatura);
        
        return new ResponseEntity<>(nuevaAsignatura, HttpStatus.CREATED);
    }
}
