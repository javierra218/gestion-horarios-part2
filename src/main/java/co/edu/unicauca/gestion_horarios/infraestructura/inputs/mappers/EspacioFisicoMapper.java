package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.EspacioFisico;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.EspacioFisicoDTOPeticion;

public class EspacioFisicoMapper {

    public static EspacioFisico toEntity(EspacioFisicoDTOPeticion dto) {
        EspacioFisico espacioFisico = new EspacioFisico();
        espacioFisico.setNombre(dto.getNombre());
        espacioFisico.setCapacidad(dto.getCapacidad());
        return espacioFisico;
    }
}