package co.edu.unicauca.gestion_horarios.dominio.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Docente extends Persona {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Oficina oficina;

    // Getter y Setter para Oficina
    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
