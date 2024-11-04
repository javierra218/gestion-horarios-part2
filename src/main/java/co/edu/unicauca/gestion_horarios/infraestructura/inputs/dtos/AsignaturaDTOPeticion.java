package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

public class AsignaturaDTOPeticion {
    private String codigo;
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