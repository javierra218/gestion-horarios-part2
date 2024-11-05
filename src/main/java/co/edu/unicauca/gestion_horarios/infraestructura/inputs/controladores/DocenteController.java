package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearDocenteCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.DocenteDTO;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers.DocenteMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private CrearDocenteCasoUso crearDocenteCasoUso;

    @PostMapping
    public ResponseEntity<Docente> crearDocente(@Valid @RequestBody DocenteDTO docenteDTO) {
        // Convertir DocenteDTO a Docente utilizando el mapper
        Docente docente = DocenteMapper.toEntity(docenteDTO);
        
        // Crear el docente a través del caso de uso
        Docente nuevoDocente = crearDocenteCasoUso.crearDocente(docente);
        
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }
}
