
package modelo;


public class Visita {
    
    private int idVisita;
    private Paciente idPaciente;
    private Empleado legajoRecepcionista;
    private String nombre;
    private int Duracion;

    public Visita(int idVisita, Paciente idPaciente, Empleado legajoRecepcionista, String nombre, int Duracion) {
        this.idVisita = idVisita;
        this.idPaciente = idPaciente;
        this.legajoRecepcionista = legajoRecepcionista;
        this.nombre = nombre;
        this.Duracion = Duracion;
    }
    
    public Visita(Paciente idPaciente, Empleado legajoRecepcionista, String nombre, int Duracion) {
        this.idPaciente = idPaciente;
        this.legajoRecepcionista = legajoRecepcionista;
        this.nombre = nombre;
        this.Duracion = Duracion;
    }

    public Visita() {
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Empleado getLegajoRecepcionista() {
        return legajoRecepcionista;
    }

    public void setLegajoRecepcionista(Empleado legajoRecepcionista) {
        this.legajoRecepcionista = legajoRecepcionista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    
    
}
