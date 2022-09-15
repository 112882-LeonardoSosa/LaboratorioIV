
package dto;


public class dtoReporte3 {
    
    private String concepto;
    private float importe;
    private String denominacion;

    public dtoReporte3() {
    }

    public dtoReporte3(String concepto, float importe, String denominacion) {
        this.concepto = concepto;
        this.importe = importe;
        this.denominacion = denominacion;
    }
    
     public Object[] toArray() {//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{concepto, importe, denominacion};
    }
    
}
