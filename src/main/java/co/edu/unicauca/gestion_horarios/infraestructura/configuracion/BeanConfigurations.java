package co.edu.unicauca.gestion_horarios.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearCursoCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearDocenteCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearFranjaHorariaCasoUso;
import co.edu.unicauca.gestion_horarios.dominio.casosDeUso.CrearAsignaturaCasoUso;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.AsignaturaRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.CursoRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.DocenteRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.EspacioFisicoRepository;
import co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios.FranjaHorariaRepository;

@Configuration
public class BeanConfigurations {

    @Bean
    public CrearCursoCasoUso crearCursoCasoUso(CursoRepository cursoRepository,
                                               AsignaturaRepository asignaturaRepository,
                                               DocenteRepository docenteRepository) {
        return new CrearCursoCasoUso(cursoRepository, asignaturaRepository, docenteRepository);
    }

    @Bean
    public CrearDocenteCasoUso crearDocenteCasoUso(DocenteRepository docenteRepository) {
        return new CrearDocenteCasoUso(docenteRepository);
    }

    @Bean
    public CrearAsignaturaCasoUso crearAsignaturaCasoUso(AsignaturaRepository asignaturaRepository) {
        return new CrearAsignaturaCasoUso(asignaturaRepository);
    }

    @Bean
    public CrearFranjaHorariaCasoUso crearFranjaHorariaCasoUso(FranjaHorariaRepository franjaHorariaRepository,
                                                               CursoRepository cursoRepository,
                                                               EspacioFisicoRepository espacioFisicoRepository) {
        return new CrearFranjaHorariaCasoUso(franjaHorariaRepository, cursoRepository, espacioFisicoRepository);
    }
}
