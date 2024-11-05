package co.edu.unicauca.gestion_horarios.infraestructura.inputs.mappers;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Asignatura;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Curso;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos.CursoDTOPeticion;

import java.util.List;

public class CursoMapper {

    public static Curso toEntity(CursoDTOPeticion dto, Asignatura asignatura, List<Docente> docentes) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setAsignatura(asignatura);
        curso.setDocentes(docentes);
        return curso;
    }
}
