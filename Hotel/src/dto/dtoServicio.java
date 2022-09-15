
package dto;


public class dtoServicio {

    private String concepto;
    private String denominacion;
    private float importe;

    public dtoServicio() {
    }

    public dtoServicio(String concepto, String denominacion, float importe) {
        this.concepto = concepto;
        this.denominacion = denominacion;
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    public Object[] toArray() {//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{concepto, denominacion, importe};
    }
}
