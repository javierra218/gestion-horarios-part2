package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DocenteDTO {
    @NotNull(message = "El nombre del docente no puede ser nulo")
    @NotEmpty(message = "El nombre del docente no puede estar vacío")
    private String nombre;

    @NotNull(message = "El apellido del docente no puede ser nulo")
    @NotEmpty(message = "El apellido del docente no puede estar vacío")
    private String apellido;

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Email(message = "Correo electrónico inválido")
    private String correo;

    @NotNull(message = "La oficina no puede ser nula")
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
