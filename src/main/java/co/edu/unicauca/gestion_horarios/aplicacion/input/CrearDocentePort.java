package co.edu.unicauca.gestion_horarios.aplicacion.input;

import java.util.List;

import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;

public interface CrearDocentePort {
    Docente crearDocente(Docente docente);
    List<Docente> listarDocentes();
}
