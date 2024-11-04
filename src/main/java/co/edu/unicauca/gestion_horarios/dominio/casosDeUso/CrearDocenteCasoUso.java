package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.gestion_horarios.aplicacion.input.CrearDocentePort;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.DocenteRepository;

@Service
public class CrearDocenteCasoUso implements CrearDocentePort {

    private final DocenteRepository docenteRepository;

    @Autowired
    public CrearDocenteCasoUso(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Docente crearDocente(Docente docente) {
        Optional<Docente> existente = docenteRepository.findByCorreo(docente.getCorreo());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un docente con el correo " + docente.getCorreo());
        }
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> listarDocentes() {
        return (List<Docente>) docenteRepository.findAll();
    }
}
