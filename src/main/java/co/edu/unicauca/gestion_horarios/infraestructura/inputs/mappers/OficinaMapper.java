package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Oficina;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.OficinaDTO;

public class OficinaMapper {

    public static Oficina toEntity(OficinaDTO dto) {
        Oficina oficina = new Oficina();
        oficina.setNombre(dto.getNombre());
        oficina.setUbicacion(dto.getUbicacion());
        return oficina;
    }

    public static OficinaDTO toDTO(Oficina oficina) {
        OficinaDTO dto = new OficinaDTO();
        dto.setNombre(oficina.getNombre());
        dto.setUbicacion(oficina.getUbicacion());
        return dto;
    }
}
