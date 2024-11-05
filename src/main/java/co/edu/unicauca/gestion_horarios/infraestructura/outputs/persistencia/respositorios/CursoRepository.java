package co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {
    boolean existsByNombreAndAsignatura(String nombre, Asignatura asignatura);
}
