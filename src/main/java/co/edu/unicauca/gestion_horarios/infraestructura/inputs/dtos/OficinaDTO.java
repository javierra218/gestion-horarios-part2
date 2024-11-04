package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OficinaDTO {
    @NotNull(message = "El nombre de la oficina no puede ser nulo")
    @NotEmpty(message = "El nombre de la oficina no puede estar vacío")
    private String nombre;

    @NotNull(message = "La ubicación de la oficina no puede ser nula")
    @NotEmpty(message = "La ubicación de la oficina no puede estar vacía")
    private String ubicacion;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}
