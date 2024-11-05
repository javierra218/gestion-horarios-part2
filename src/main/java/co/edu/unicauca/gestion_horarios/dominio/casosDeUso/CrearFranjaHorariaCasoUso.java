package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers.FranjaHorariaMapper;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.FranjaHorariaRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.CursoRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.EspacioFisicoRepository;

import java.util.Optional;

@Service
public class CrearFranjaHorariaCasoUso {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final CursoRepository cursoRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;

    @Autowired
    public CrearFranjaHorariaCasoUso(FranjaHorariaRepository franjaHorariaRepository, CursoRepository cursoRepository,
            EspacioFisicoRepository espacioFisicoRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.cursoRepository = cursoRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    public FranjaHoraria crearFranjaHoraria(FranjaHorariaDTOPeticion dto) {
        // Obtener curso
        Optional<Curso> cursoOpt = cursoRepository.findById(dto.getCursoId());
        if (cursoOpt.isEmpty()) {
            throw new IllegalArgumentException("El curso especificado no existe.");
        }

        // Obtener espacio físico
        Optional<EspacioFisico> espacioFisicoOpt = espacioFisicoRepository.findById(dto.getEspacioFisicoId());
        if (espacioFisicoOpt.isEmpty()) {
            throw new IllegalArgumentException("El espacio físico especificado no existe.");
        }

        // Usar el mapper para convertir el DTO a una entidad FranjaHoraria
        FranjaHoraria franjaHoraria = FranjaHorariaMapper.toEntity(dto, cursoOpt.get(), espacioFisicoOpt.get());

        // Guardar la franja horaria en el repositorio
        return franjaHorariaRepository.save(franjaHoraria);
    }
}
