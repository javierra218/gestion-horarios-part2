package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.CursoDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.AsignaturaRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.CursoRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.DocenteRepository;

@Service
public class CrearCursoCasoUso {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    public Curso crearCurso(CursoDTOPeticion dto) {
        Optional<Asignatura> asignaturaOpt = asignaturaRepository.findByCodigo(dto.getCodigoAsignatura());
        if (asignaturaOpt.isEmpty()) {
            throw new IllegalArgumentException("La asignatura especificada no existe.");
        }

        Asignatura asignatura = asignaturaOpt.get();
        List<Docente> docentes = new ArrayList<>();
        for (Integer docenteId : dto.getDocentesIds()) {
            Optional<Docente> docenteOpt = docenteRepository.findById(docenteId);
            docenteOpt.ifPresentOrElse(docentes::add, () -> {
                throw new IllegalArgumentException("El docente con ID " + docenteId + " no existe.");
            });
        }

        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setAsignatura(asignatura);
        curso.setDocentes(docentes);

        return cursoRepository.save(curso);
    }
}