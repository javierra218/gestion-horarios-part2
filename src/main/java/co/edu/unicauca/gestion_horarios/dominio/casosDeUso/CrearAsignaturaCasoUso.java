package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.AsignaturaDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.AsignaturaRepository;

@Service
public class CrearAsignaturaCasoUso {

    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public CrearAsignaturaCasoUso(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public Asignatura crearAsignatura(AsignaturaDTOPeticion dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setCodigo(dto.getCodigo());
        asignatura.setNombre(dto.getNombre());

        return asignaturaRepository.save(asignatura);
    }
}
