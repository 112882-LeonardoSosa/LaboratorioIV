
package dto;


public class dtoReporte2 {
    
    private int idHabitacion;
    private float sumaServicios;

    public dtoReporte2(int idServicio, float sumaServicios) {
        this.idHabitacion = idServicio;
        this.sumaServicios = sumaServicios;
    }

    public dtoReporte2() {
    }

    public int getIdServicio() {
        return idHabitacion;
    }

    public void setIdServicio(int idServicio) {
        this.idHabitacion = idServicio;
    }

    public float getSumaServicios() {
        return sumaServicios;
    }

    public void setSumaServicios(float sumaServicios) {
        this.sumaServicios = sumaServicios;
    }

    @Override
    public String toString() {
        return "dtoReporte2{" + "idServicio=" + idHabitacion + ", sumaServicios=" + sumaServicios + '}';
    }
    
     public Object[] toArray() {//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{idHabitacion, sumaServicios};
    }
    
}
