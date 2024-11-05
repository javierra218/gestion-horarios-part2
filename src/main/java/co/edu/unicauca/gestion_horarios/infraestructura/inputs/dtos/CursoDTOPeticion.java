package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoDTOPeticion {
    @NotEmpty(message = "{curso.nombre.empty}")
    @Size(min = 3, max = 50, message = "{curso.nombre.size}")
    private String nombre;

    @NotEmpty(message = "{curso.codigoAsignatura.empty}")
    private String codigoAsignatura;

    @NotNull(message = "{curso.docentesIds.empty}")
    private List<@NotNull(message = "{curso.docenteId.invalid}") Integer> docentesIds;

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
