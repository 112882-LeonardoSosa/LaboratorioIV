
package controller;

import models.Servicio;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ServicioController {
    
    String cadena = "jdbc:sqlserver://localhost:1433; database=HOTEL; user=sa; password=3103; loginTimeout=30; TrustServerCertificate=true";
    
    public void altaServicio(Servicio obj){
        
        try {
            Connection conexion = DriverManager.getConnection(cadena);
            
            java.sql.PreparedStatement ps = conexion.prepareStatement("insert into Servicios (Concepto,IdHabitacion,Importe)"
                    + "values (?,?,?)");
            
            ps.setString(1, obj.getConcepto());
            ps.setInt(2, obj.getHabitacion().getIdHabitacion());
            ps.setFloat(3, obj.getImporte());
            
            ps.executeUpdate();
            
            ps.close();
            conexion.close();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
}
