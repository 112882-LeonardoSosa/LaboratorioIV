

package dto;


public class dtoTransaccion {
    
    private String fecha;
    private int idVendedor;
    private int tipoOperacion;
    private int tipoInmueble;
    private float monto;

    public dtoTransaccion() {
    }

    public dtoTransaccion(String fecha, int idVendedor, int tipoOperacion, int tipoInmueble, float monto) {
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }
    
    public Object[] toArray() {//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{fecha, idVendedor, tipoOperacion,tipoOperacion, monto};
    }
}
