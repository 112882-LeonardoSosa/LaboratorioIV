
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import view.frmPrincipal;


public class Ejecutable {


    public static void main(String[] args) {
        
        //PROBAR CONEXION FIRST STEP
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; database=HOTEL; user=sa; password=123leo; loginTimeout=30; TrustServerCertificate=true");
//            System.out.println("Conexion Exitosa");
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery("select * from Servicios");
//            
//            while (rs.next()) {
//                //Una vuelta por cada fila retornada
//                
//            }
//            
//            conexion.close();
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }

            frmPrincipal formPrincipal = new frmPrincipal();
            formPrincipal.setVisible(true);
    }
    
}
