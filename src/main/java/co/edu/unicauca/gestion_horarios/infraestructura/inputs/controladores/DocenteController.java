package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearDocenteCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Oficina;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.DocenteDTO;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.OficinaDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private CrearDocenteCasoUso crearDocenteCasoUso;

    @PostMapping
    public ResponseEntity<Docente> crearDocente(@Valid @RequestBody DocenteDTO docenteDTO) {
        Docente docente = mapearADocente(docenteDTO);
        Docente nuevoDocente = crearDocenteCasoUso.crearDocente(docente);
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }

    // Método de mapeo de DocenteDTO a Docente
    private Docente mapearADocente(DocenteDTO dto) {
        Docente docente = new Docente();
        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setCorreo(dto.getCorreo());

        Oficina oficina = new Oficina();
        oficina.setNombre(dto.getOficina().getNombre());
        oficina.setUbicacion(dto.getOficina().getUbicacion());
        docente.setOficina(oficina);

        return docente;
    }
}
