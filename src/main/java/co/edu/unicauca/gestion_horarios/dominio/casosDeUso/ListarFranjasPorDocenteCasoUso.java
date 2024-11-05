package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.FranjaHorariaRepository;

import java.util.List;

@Service
public class ListarFranjasPorDocenteCasoUso {

    private final FranjaHorariaRepository franjaHorariaRepository;

    @Autowired
    public ListarFranjasPorDocenteCasoUso(FranjaHorariaRepository franjaHorariaRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
    }

    public List<FranjaHoraria> listarFranjasPorDocente(int docenteId) {
        // Lógica para obtener las franjas horarias del docente
        return franjaHorariaRepository.findByDocenteId(docenteId);
    }
}
