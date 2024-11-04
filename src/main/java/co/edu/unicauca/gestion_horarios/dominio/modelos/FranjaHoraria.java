package co.edu.unicauca.gestion_horarios.dominio.modelos;

import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class FranjaHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dia;
    private Time horaInicio;
    private Time horaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"franjasHorarias", "docentes"}) // Evita serializar listas recursivas en Curso
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("nombre") // Incluye solo el nombre del EspacioFisico, omitiendo otras propiedades
    private EspacioFisico espacioFisico;

    // Constructor sin argumentos
    public FranjaHoraria() {}

    // Constructor con argumentos
    public FranjaHoraria(String dia, Time horaInicio, Time horaFin, Curso curso, EspacioFisico espacioFisico) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.curso = curso;
        this.espacioFisico = espacioFisico;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public EspacioFisico getEspacioFisico() {
        return espacioFisico;
    }

    public void setEspacioFisico(EspacioFisico espacioFisico) {
        this.espacioFisico = espacioFisico;
    }

    @Override
    public String toString() {
        return "FranjaHoraria{" +
                "id=" + id +
                ", dia='" + dia + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", curso=" + (curso != null ? curso.getNombre() : "null") +
                ", espacioFisico=" + (espacioFisico != null ? espacioFisico.getNombre() : "null") +
                '}';
    }
}
