package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OficinaDTO {
    @NotNull(message = "{oficina.nombre.empty}")
    @NotEmpty(message = "{oficina.nombre.empty}")
    private String nombre;

    @NotNull(message = "{oficina.ubicacion.empty}")
    @NotEmpty(message = "{oficina.ubicacion.empty}")
    private String ubicacion;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}
