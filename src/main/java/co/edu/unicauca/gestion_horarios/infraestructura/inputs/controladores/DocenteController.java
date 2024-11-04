package co.edu.unicauca.gestion_horarios.infraestructura.inputs.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearDocenteCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private CrearDocenteCasoUso crearDocenteCasoUso;

    @PostMapping
    public ResponseEntity<Docente> crearDocente(@RequestBody Docente docente) {
        Docente nuevoDocente = crearDocenteCasoUso.crearDocente(docente);
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Docente>> listarDocentes() {
        List<Docente> docentes = (List<Docente>) crearDocenteCasoUso.listarDocentes();
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }
}
