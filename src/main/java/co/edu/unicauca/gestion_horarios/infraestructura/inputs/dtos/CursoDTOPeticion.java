package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import java.util.List;

public class CursoDTOPeticion {
    private String nombre;
    private String codigoAsignatura;
    private List<Integer> docentesIds;

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public List<Integer> getDocentesIds() {
        return docentesIds;
    }

}
