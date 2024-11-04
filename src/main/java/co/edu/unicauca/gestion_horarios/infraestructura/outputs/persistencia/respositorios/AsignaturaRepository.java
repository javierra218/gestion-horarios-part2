package co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer> {
    Optional<Asignatura> findByCodigo(String codigo);
}
