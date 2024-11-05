package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearFranjaHorariaCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTOPeticion;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/franjas")
public class FranjaHorariaController {

    @Autowired
    private CrearFranjaHorariaCasoUso crearFranjaHorariaCasoUso;

    @PostMapping
    public ResponseEntity<FranjaHoraria> crearFranjaHoraria(@Valid @RequestBody FranjaHorariaDTOPeticion dto) {
        // Crear la franja horaria en el caso de uso
        FranjaHoraria nuevaFranja = crearFranjaHorariaCasoUso.crearFranjaHoraria(dto);
        
        return new ResponseEntity<>(nuevaFranja, HttpStatus.CREATED);
    }
}
