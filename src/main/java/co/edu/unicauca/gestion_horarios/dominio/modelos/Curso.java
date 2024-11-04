package co.edu.unicauca.gestion_horarios.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Asignatura asignatura;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Docente> docentes = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita la serialización de la lista de franjas para prevenir la recursividad
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<FranjaHoraria> getFranjasHorarias() {
        return franjasHorarias;
    }

    public void setFranjasHorarias(List<FranjaHoraria> franjasHorarias) {
        this.franjasHorarias = franjasHorarias;
    }
}
