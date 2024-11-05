package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EspacioFisicoDTOPeticion {
    @NotEmpty(message = "{espacio_fisico.nombre.empty}")
    @Size(min = 3, max = 50, message = "{espacio_fisico.nombre.size}")
    private String nombre;

    @NotNull(message = "{espacio_fisico.capacidad.empty}")
    private Integer capacidad;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}