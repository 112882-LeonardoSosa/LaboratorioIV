
package models;


public class Habitacion {
    private int idHabitacion;
    private String Denominacion;

    public Habitacion(int idHabitacion, String Denominacion) {
        this.idHabitacion = idHabitacion;
        this.Denominacion = Denominacion;
    }

    public Habitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }
    
    
}
