package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTOPeticion;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.FranjaHorariaDTORespuesta;

public class FranjaHorariaMapper {

    public static FranjaHoraria toEntity(FranjaHorariaDTOPeticion dto, Curso curso, EspacioFisico espacioFisico) {
        FranjaHoraria franjaHoraria = new FranjaHoraria();
        franjaHoraria.setDia(dto.getDia());
        franjaHoraria.setHoraInicio(dto.getHoraInicio());
        franjaHoraria.setHoraFin(dto.getHoraFin());
        franjaHoraria.setCurso(curso);
        franjaHoraria.setEspacioFisico(espacioFisico);
        return franjaHoraria;
    }

    public static FranjaHorariaDTORespuesta toDTO(FranjaHoraria franjaHoraria) {
        return new FranjaHorariaDTORespuesta(
                franjaHoraria.getId(),
                franjaHoraria.getDia(),
                franjaHoraria.getHoraInicio().toString(),
                franjaHoraria.getHoraFin().toString(),
                franjaHoraria.getCurso().getNombre(),
                franjaHoraria.getEspacioFisico().getNombre()
        );
    }
}
