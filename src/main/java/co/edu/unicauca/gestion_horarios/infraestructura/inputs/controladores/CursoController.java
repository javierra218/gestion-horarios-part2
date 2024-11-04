package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearCursoCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.CursoDTOPeticion;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CrearCursoCasoUso crearCursoCasoUso;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@Valid @RequestBody CursoDTOPeticion dto) {
        Curso nuevoCurso = crearCursoCasoUso.crearCurso(dto);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }
}