package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Oficina;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.DocenteDTO;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.OficinaDTO;

public class DocenteMapper {

    public static Docente toEntity(DocenteDTO dto) {
        Docente docente = new Docente();
        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setCorreo(dto.getCorreo());

        Oficina oficina = OficinaMapper.toEntity(dto.getOficina());
        docente.setOficina(oficina);
        return docente;
    }

    public static DocenteDTO toDTO(Docente docente) {
        DocenteDTO dto = new DocenteDTO();
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setCorreo(docente.getCorreo());

        OficinaDTO oficinaDTO = OficinaMapper.toDTO(docente.getOficina());
        dto.setOficina(oficinaDTO);
        return dto;
    }
}
