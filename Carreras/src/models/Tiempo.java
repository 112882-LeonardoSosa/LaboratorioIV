
package models;


public class Tiempo {
    
    private int id;
    private Corredor corredor;
    private float tiempo;
    private String club;
    private String clima;

    public Tiempo() {
    }

    public Tiempo(int id, Corredor corredor, float tiempo, String club, String clima) {
        this.id = id;
        this.corredor = corredor;
        this.tiempo = tiempo;
        this.club = club;
        this.clima = clima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
    
    public Object[] toArray() {//ME CONVIERTE EL OBJETO EN UNA FILA
        return new Object[]{id, corredor, club, clima};
    }
    
}
