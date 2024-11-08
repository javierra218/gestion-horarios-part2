package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.CursoDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers.CursoMapper;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.AsignaturaRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.CursoRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.DocenteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrearCursoCasoUso {

    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final DocenteRepository docenteRepository;

    @Autowired
    public CrearCursoCasoUso(CursoRepository cursoRepository, AsignaturaRepository asignaturaRepository,
            DocenteRepository docenteRepository) {
        this.cursoRepository = cursoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.docenteRepository = docenteRepository;
    }

    public Curso crearCurso(CursoDTOPeticion dto) {
        // Buscar asignatura
        Optional<Asignatura> asignaturaOpt = asignaturaRepository.findByCodigo(dto.getCodigoAsignatura());
        if (asignaturaOpt.isEmpty()) {
            throw new IllegalArgumentException("La asignatura especificada no existe.");
        }

        // Validar si el curso ya existe
        if (cursoRepository.existsByNombreAndAsignatura(dto.getNombre(), asignaturaOpt.get())) {
            throw new IllegalArgumentException(
                    "El curso con el nombre especificado ya existe para la asignatura proporcionada.");
        }

        // Buscar docentes
        List<Docente> docentes = new ArrayList<>();
        for (Integer docenteId : dto.getDocentesIds()) {
            Optional<Docente> docenteOpt = docenteRepository.findById(docenteId);
            docenteOpt.ifPresentOrElse(docentes::add, () -> {
                throw new IllegalArgumentException("El docente con ID " + docenteId + " no existe.");
            });
        }

        // Usar el mapper para convertir DTO a entidad Curso
        Curso curso = CursoMapper.toEntity(dto, asignaturaOpt.get(), docentes);
        return cursoRepository.save(curso);
    }

}
