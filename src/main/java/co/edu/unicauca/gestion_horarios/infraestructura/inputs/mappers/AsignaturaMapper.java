package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.AsignaturaDTOPeticion;

public class AsignaturaMapper {

    public static Asignatura toEntity(AsignaturaDTOPeticion dto) {
        Asignatura asignatura = new Asignatura();
        asignatura.setCodigo(dto.getCodigo());
        asignatura.setNombre(dto.getNombre());
        return asignatura;
    }

    public static AsignaturaDTOPeticion toDTO(Asignatura asignatura) {
        AsignaturaDTOPeticion dto = new AsignaturaDTOPeticion();
        dto.setCodigo(asignatura.getCodigo());
        dto.setNombre(asignatura.getNombre());
        return dto;
    }
}
