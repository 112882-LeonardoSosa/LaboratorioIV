package controller;

import dto.dtoTransaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Transaccion;
import models.Vendedor;

public class TransaccionController {

    String cadena = "jdbc:sqlserver://localhost:1433; database=Inmobiliaria; user=sa; password=3103; loginTimeout=30; TrustServerCertificate=true";

    public TransaccionController() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado!");
            return;
        }
    }

    //▪ Insertar una transacción. 
    public void altaTransaccion(Transaccion obj) {

        try {
            Connection conexion = DriverManager.getConnection(cadena);

            java.sql.PreparedStatement ps = conexion.prepareStatement("insert into Transacciones (Fecha,idVendedor,tipoOperacion, tipoInmueble)"
                    + "values (?,?,?,?)");

            ps.setString(1, obj.getFecha());
            ps.setInt(2, obj.getVendedor().getId());
            ps.setInt(3, obj.getTipoOperacion());
            ps.setInt(4, obj.getTipoInmueble());

            ps.executeUpdate();

            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public ArrayList<Vendedor> obtenerVendedores() {
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Vendedores");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nombre = rs.getString("NombreCompleto");
                Vendedor v = new Vendedor(id, nombre);
                listaVendedores.add(v);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVendedores;
    }

//        ▪ Generar un reporte que informe todas las transacciones registradas.
    public ArrayList<dtoTransaccion> obtenerTransacciones() {
        ArrayList<dtoTransaccion> listaTransacciones = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Transacciones");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                String fecha = rs.getString("Fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOperacion = rs.getInt("tipoOperacion");
                int tipoInmueble = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                dtoTransaccion t = new dtoTransaccion(fecha, idVendedor, tipoOperacion, tipoInmueble, monto);
                listaTransacciones.add(t);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTransacciones;
    }
//        ▪ Datos completo de la transacción (que sea Venta) de mayor valor (monto). 

    public dtoTransaccion mayorTransaccion() {
        dtoTransaccion t = null;

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * \n"
                    + "from Transacciones\n"
                    + "where tipoOperacion = 2 and monto = (select max(monto)\n"
                    + "				from transacciones)");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            if (rs.next()) {
                String fecha = rs.getString("Fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOperacion = rs.getInt("tipoOperacion");
                int tipoInmueble = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                t = new dtoTransaccion(fecha, idVendedor, tipoOperacion, tipoInmueble, monto);

            }
            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

//        ▪ Porcentaje de transacciones de tipo Alquiler. 
    public float porcentajeTransaccion() {
        float porcentaje = 0;

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select (CONVERT(FLOAT,COUNT(id)) / 100) as 'PorcentajeTransacciones'\n"
                    + "from Transacciones\n"
                    + "where tipoOperacion = 1");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            if (rs.next()) {
                porcentaje = rs.getFloat("PorcentajeTransacciones");

            }
            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return porcentaje;
    }

//        ▪ Informar las transacciones (todos sus datos) cuyo tipo de inmueble sea Oficina. 
    public ArrayList<dtoTransaccion> tipoOfina() {
        ArrayList<dtoTransaccion> listaTransacciones = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from transacciones where tipoInmueble = 1");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                String fecha = rs.getString("Fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOperacion = rs.getInt("tipoOperacion");
                int tipoInmueble = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                dtoTransaccion t = new dtoTransaccion(fecha, idVendedor, tipoOperacion, tipoInmueble, monto);
                listaTransacciones.add(t);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTransacciones;
    }

}
