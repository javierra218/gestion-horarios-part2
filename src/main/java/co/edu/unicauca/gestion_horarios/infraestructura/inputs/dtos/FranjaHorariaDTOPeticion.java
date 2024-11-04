package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotNull;
import java.sql.Time;

public class FranjaHorariaDTOPeticion {
    // Propiedades
    private Integer cursoId;
    private Integer espacioFisicoId;
    private String dia;
    private Time horaInicio;
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