package co.edu.unicauca.gestion_horarios.dominio.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.gestion_horarios.aplicacion.input.CrearDocentePort;
import co.edu.unicauca.gestion_horarios.dominio.modelos.Docente;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.DocenteRepository;

@Service
public class CrearDocenteCasoUso implements CrearDocentePort {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public Docente crearDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> listarDocentes() {
        return (List<Docente>) docenteRepository.findAll();
    }
}
