
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import models.Tiempo;


public class TiemposController {
    
    private String cadena = "jdbc:sqlserver://localhost:1433; database=Carreras; user=sa; password=123leo; loginTimeout=30; TrustServerCertificate=true";
    
    public void altaTiempo(Tiempo obj) {

        try {
            Connection conexion = DriverManager.getConnection(cadena);

            java.sql.PreparedStatement ps = conexion.prepareStatement("insert into Tiempos (IdCorredor,Tiempo,Club,Clima)"
                    + "values (?,?,?,?)");

            ps.setInt(1, obj.getCorredor().getId());
            ps.setFloat(2, obj.getTiempo());
            ps.setString(3, obj.getClub());
            ps.setString(4, obj.getClima());

            ps.executeUpdate();

            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    
    
    
}
