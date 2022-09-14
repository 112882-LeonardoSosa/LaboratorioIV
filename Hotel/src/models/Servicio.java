
package models;


public class Servicio {
    
    private int idServicio;
    private String Concepto;
    private Habitacion habitacion;
    private float importe;

    public Servicio() {
    }

    public Servicio(int idServicio, String Concepto, Habitacion habitacion, float importe) {
        this.idServicio = idServicio;
        this.Concepto = Concepto;
        this.habitacion = habitacion;
        this.importe = importe;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
}
