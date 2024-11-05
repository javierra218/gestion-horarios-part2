package co.edu.unicauca.gestion_horarios.infraestructura.inputs.dtos;

public class FranjaHorariaDTORespuesta {
    private Integer id;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String nombreCurso;
    private String nombreEspacioFisico;

    // Constructor
    public FranjaHorariaDTORespuesta(Integer id, String dia, String horaInicio, String horaFin,
                                     String nombreCurso, String nombreEspacioFisico) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.nombreCurso = nombreCurso;
        this.nombreEspacioFisico = nombreEspacioFisico;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreEspacioFisico() {
        return nombreEspacioFisico;
    }

    public void setNombreEspacioFisico(String nombreEspacioFisico) {
        this.nombreEspacioFisico = nombreEspacioFisico;
    }
}
