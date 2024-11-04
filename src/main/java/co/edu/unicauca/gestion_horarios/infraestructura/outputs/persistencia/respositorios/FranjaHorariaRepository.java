package co.edu.unicauca.gestion_horarios.infraestructura.outputs.persistencia.respositorios;

import java.sql.Time;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.edu.unicauca.gestion_horarios.dominio.modelos.FranjaHoraria;

public interface FranjaHorariaRepository extends CrudRepository<FranjaHoraria, Integer> {

    @Query("SELECT COUNT(f) > 0 FROM FranjaHoraria f JOIN f.espacioFisico e WHERE e.id = :espacioId AND f.dia = :dia AND (f.horaInicio < :horaFin AND f.horaFin > :horaInicio)")
    boolean isEspacioFisicoOcupado(@Param("espacioId") int espacioId, 
                                   @Param("dia") String dia,
                                   @Param("horaInicio") Time horaInicio, 
                                   @Param("horaFin") Time horaFin);

    @Query(value = "SELECT COUNT(*) FROM franja_horaria f JOIN curso c ON f.curso_id = c.id JOIN curso_docentes cd ON cd.curso_id = c.id WHERE cd.docentes_id = :docenteId AND f.dia = :dia AND (f.hora_inicio < :horaFin AND f.hora_fin > :horaInicio)", nativeQuery = true)
    Long countDocenteOcupado(@Param("docenteId") int docenteId, 
                             @Param("dia") String dia,
                             @Param("horaInicio") Time horaInicio, 
                             @Param("horaFin") Time horaFin);
}
