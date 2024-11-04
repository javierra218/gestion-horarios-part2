package co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;

public interface EspacioFisicoRepository extends CrudRepository<EspacioFisico, Integer> {
    List<EspacioFisico> findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombre(String nombre, int capacidad);
}
