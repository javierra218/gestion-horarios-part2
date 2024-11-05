package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.EspacioFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrearEspacioFisicoCasoUso {

    private final EspacioFisicoRepository espacioFisicoRepository;

    @Autowired
    public CrearEspacioFisicoCasoUso(EspacioFisicoRepository espacioFisicoRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    public EspacioFisico crearEspacioFisico(EspacioFisico espacioFisico) {
        return espacioFisicoRepository.save(espacioFisico);
    }

    public List<EspacioFisico> listarEspaciosFisicos(String nombre, int capacidad) {
        return espacioFisicoRepository.findByNombreStartingWithIgnoreCaseAndCapacidadGreaterThanEqualOrderByNombre(nombre, capacidad);
    }
}