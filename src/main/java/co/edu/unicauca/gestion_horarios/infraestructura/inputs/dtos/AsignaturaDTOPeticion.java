package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AsignaturaDTOPeticion {
    @NotEmpty(message = "{asignatura.codigo.empty}")
    @Size(min = 3, max = 7, message = "{asignatura.codigo.size}")
    private String codigo;

    @NotEmpty(message = "{asignatura.nombre.empty}")
    @Size(min = 3, max = 50, message = "{asignatura.nombre.size}")
    private String nombre;

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}