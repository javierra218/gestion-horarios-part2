package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotNull;
import java.sql.Time;

public class FranjaHorariaDTOPeticion {
    // Propiedades
    @NotNull(message = "{franja_horaria.cursoId.empty}")
    private Integer cursoId;

    @NotNull(message = "{franja_horaria.espacioFisicoId.empty}")
    private Integer espacioFisicoId;

    @NotNull(message = "{franja_horaria.dia.empty}")
    private String dia;

    @NotNull(message = "{franja_horaria.horaInicio.empty}")
    private Time horaInicio;

    @NotNull(message = "{franja_horaria.horaFin.empty}")
    private Time horaFin;

    // Getters y Setters
    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Integer getEspacioFisicoId() {
        return espacioFisicoId;
    }

    public void setEspacioFisicoId(Integer espacioFisicoId) {
        this.espacioFisicoId = espacioFisicoId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
}