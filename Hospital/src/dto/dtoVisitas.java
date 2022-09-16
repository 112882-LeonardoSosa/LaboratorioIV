
package dto;


public class dtoVisitas {
    
    private String nombrePaciente;
    private String nombreVisitante;
    private String nombreRecepcionista;
    private int duracion;

    public dtoVisitas(String nombrePaciente, String nombreVisitante, String nombreRecepcionista, int duracion) {
        this.nombrePaciente = nombrePaciente;
        this.nombreVisitante = nombreVisitante;
        this.nombreRecepcionista = nombreRecepcionista;
        this.duracion = duracion;
    }

    public dtoVisitas() {
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getNombreRecepcionista() {
        return nombreRecepcionista;
    }

    public void setNombreRecepcionista(String nombreRecepcionista) {
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public Object[] toArray(){//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{nombrePaciente, nombreVisitante, nombreRecepcionista,duracion};
    }
    

}
