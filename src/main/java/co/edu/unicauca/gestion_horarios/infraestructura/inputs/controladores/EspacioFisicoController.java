package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearEspacioFisicoCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.EspacioFisicoDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers.EspacioFisicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioFisicoController {

    @Autowired
    private CrearEspacioFisicoCasoUso espacioFisicoCasoUso;

    @PostMapping
    public ResponseEntity<EspacioFisico> crearEspacioFisico(@Valid @RequestBody EspacioFisicoDTOPeticion dto) {
        EspacioFisico espacioFisico = EspacioFisicoMapper.toEntity(dto);
        EspacioFisico nuevoEspacio = espacioFisicoCasoUso.crearEspacioFisico(espacioFisico);
        return new ResponseEntity<>(nuevoEspacio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EspacioFisico>> listarEspaciosFisicos(
            @RequestParam(value = "nombre", defaultValue = "") String nombre,
            @RequestParam(value = "capacidad", defaultValue = "0") int capacidad) {
        List<EspacioFisico> espacios = espacioFisicoCasoUso.listarEspaciosFisicos(nombre, capacidad);
        return new ResponseEntity<>(espacios, HttpStatus.OK);
    }
}
