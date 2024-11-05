package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.AsignaturaRepository;
import java.util.Optional;

@Service
public class CrearAsignaturaCasoUso {

    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public CrearAsignaturaCasoUso(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public Asignatura crearAsignatura(Asignatura asignatura) {
        // Verificar si ya existe una asignatura con el mismo código
        Optional<Asignatura> asignaturaExistente = asignaturaRepository.findByCodigo(asignatura.getCodigo());
        if (asignaturaExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una asignatura con el código " + asignatura.getCodigo());
        }

        return asignaturaRepository.save(asignatura);
    }
}
