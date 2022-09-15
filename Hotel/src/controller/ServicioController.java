package controller;

import dto.dtoReporte2;
import dto.dtoServicio;
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

    public void altaServicio(Servicio obj) {

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

    public ArrayList<dtoServicio> obtenerServicios() {
        ArrayList<dtoServicio> listaServicios = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select Concepto, Denominacion, Importe \n"
                    + "from Servicios s join Habitaciones h \n"
                    + "on s.IdHabitacion = h.IdHabitacion");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                String concepto = rs.getString("Concepto");
                String denominacion = rs.getString("Denominacion");
                float importe = rs.getFloat("Importe");
                dtoServicio s = new dtoServicio(concepto, denominacion, importe);
                listaServicios.add(s);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaServicios;
    }

    public int totalServiciosContratados() {
        int total = 0;

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select count(IdServicio) 'Total Servicios Contratados'\n"
                    + "from Servicios");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            if (rs.next()) {
                total = rs.getInt("Total Servicios Contratados");

            }
            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }

    public ArrayList<dtoReporte2> Reporte2() {
        ArrayList<dtoReporte2> listaServicios = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select h.IdHabitacion, sum(Importe) 'sumaServicios' \n"
                    + "from Servicios s join Habitaciones h \n"
                    + "on s.IdHabitacion = h.IdHabitacion\n"
                    + "group by  h.IdHabitacion\n"
                    + "having count(IdServicio) > 3");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("IdHabitacion");
                float suma = rs.getFloat("sumaServicios");
                dtoReporte2 s = new dtoReporte2(id, suma);
                listaServicios.add(s);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaServicios;
    }
}
