package co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;

public interface DocenteRepository extends CrudRepository<Docente, Integer> {
    Optional<Docente> findByCorreo(String correo);
}
