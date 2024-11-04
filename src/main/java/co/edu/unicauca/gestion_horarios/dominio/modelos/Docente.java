package co.edu.unicauca.gestion_horarios.dominio.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Docente extends Persona {
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Oficina oficina;
}
