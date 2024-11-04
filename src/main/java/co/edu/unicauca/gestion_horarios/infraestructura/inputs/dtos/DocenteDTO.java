package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DocenteDTO {
    @NotNull(message = "{docente.nombre.empty}")
    @NotEmpty(message = "{docente.nombre.empty}")
    @Size(min = 2, max = 50, message = "{docente.nombre.size}")
    private String nombre;

    @NotNull(message = "{docente.apellido.empty}")
    @NotEmpty(message = "{docente.apellido.empty}")
    private String apellido;

    @NotNull(message = "{docente.correo.empty}")
    @Email(message = "{docente.correo.invalid}")
    private String correo;

    @NotNull(message = "{docente.oficina.empty}")
    private OficinaDTO oficina;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public OficinaDTO getOficina() { return oficina; }
    public void setOficina(OficinaDTO oficina) { this.oficina = oficina; }
}
