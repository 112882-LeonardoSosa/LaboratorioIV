
package controller;

import models.Servicio;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Habitacion;


public class ServicioController {
    
    String cadena = "jdbc:sqlserver://localhost:1433; database=HOTEL; user=sa; password=123leo; loginTimeout=30; TrustServerCertificate=true";
    
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

     public ArrayList<Habitacion> obtenerHabitaciones() {
        ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Habitaciones");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("IdHabitacion");
                String nombre = rs.getString("Denominacion");
                Habitacion h = new Habitacion(id, nombre);
                listaHabitaciones.add(h);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaHabitaciones;
    }
}
