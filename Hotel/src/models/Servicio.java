
package models;


public class Servicio {
    
    private int idServicio;
    private String Concepto;
    private Habitacion habitacion;
    private float importe;

    public Servicio() {
    }

    public Servicio(String Concepto, Habitacion habitacion, float importe) {
        this.Concepto = Concepto;
        this.habitacion = habitacion;
        this.importe = importe;
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

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", Concepto=" + Concepto + ", habitacion=" + habitacion.getDenominacion() + ", importe=" + importe + '}';
    }
    
    
    
        public Object[] toArray(){//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{idServicio, Concepto, habitacion, importe };
    }
}
