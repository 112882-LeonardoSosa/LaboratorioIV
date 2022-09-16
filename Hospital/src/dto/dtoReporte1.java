
package dto;


public class dtoReporte1 {
    
    private String nombrePaciente;
    private int cantidadVisitas;

    public dtoReporte1(String nombrePaciente, int cantidadVisitas) {
        this.nombrePaciente = nombrePaciente;
        this.cantidadVisitas = cantidadVisitas;
    }

    public String getnombrePaciente() {
        return nombrePaciente;
    }

    public void setNombreRecepcionista(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public float getcantidadVisitas() {
        return cantidadVisitas;
    }

    public void setPromedio(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }
    
    public Object[] toArray(){//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{nombrePaciente, cantidadVisitas};
    }
    
}
