

package dto;


public class dtoReporte2 {
    
    private float promedio;

    public dtoReporte2(float promedio) {
        this.promedio = promedio;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
     public Object[] toArray(){//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{promedio};
    }

}
