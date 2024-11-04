package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTOPeticion;
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
    public CrearFranjaHorariaCasoUso(FranjaHorariaRepository franjaHorariaRepository, CursoRepository cursoRepository, EspacioFisicoRepository espacioFisicoRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
        this.cursoRepository = cursoRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    public FranjaHoraria crearFranjaHoraria(FranjaHorariaDTOPeticion dto) {
        Optional<Curso> curso = cursoRepository.findById(dto.getCursoId());
        Optional<EspacioFisico> espacioFisico = espacioFisicoRepository.findById(dto.getEspacioFisicoId());

        if (curso.isEmpty()) {
            throw new IllegalArgumentException("El curso especificado no existe.");
        }
        if (espacioFisico.isEmpty()) {
            throw new IllegalArgumentException("El espacio físico especificado no existe.");
        }

        boolean espacioOcupado = franjaHorariaRepository.isEspacioFisicoOcupado(dto.getEspacioFisicoId(), dto.getDia(), dto.getHoraInicio(), dto.getHoraFin());
        if (espacioOcupado) {
            throw new IllegalArgumentException("El espacio físico está ocupado en el horario solicitado.");
        }

        boolean docenteOcupado = franjaHorariaRepository.countDocenteOcupado(dto.getCursoId(), dto.getDia(), dto.getHoraInicio(), dto.getHoraFin()) > 0;
        if (docenteOcupado) {
            throw new IllegalArgumentException("El docente está ocupado en el horario solicitado.");
        }

        FranjaHoraria franjaHoraria = new FranjaHoraria();
        franjaHoraria.setCurso(curso.get());
        franjaHoraria.setEspacioFisico(espacioFisico.get());
        franjaHoraria.setDia(dto.getDia());
        franjaHoraria.setHoraInicio(dto.getHoraInicio());
        franjaHoraria.setHoraFin(dto.getHoraFin());

        return franjaHorariaRepository.save(franjaHoraria);
    }
}
