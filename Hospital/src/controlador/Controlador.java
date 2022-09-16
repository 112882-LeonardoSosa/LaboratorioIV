package controlador;

import dto.dtoReporte1;
import dto.dtoReporte2;
import dto.dtoVisitas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import modelo.Paciente;
import modelo.Visita;

public class Controlador {
    
    String cadena = "jdbc:sqlserver://localhost:1433; database=Visitas; user=sa; password=3103; loginTimeout=30; TrustServerCertificate=true";

    public void agregarVisita(Visita nueva) {

        try {

            Connection conexion = DriverManager.getConnection(cadena);

            //CUANDO LA CONSULTA TIENE PARAMETROS USAMOS EL PREPARED STATEMENT
            java.sql.PreparedStatement comando = conexion.prepareStatement("insert into Visitas(IdPaciente, LegajoRecepcionista, Nombre, Duracion)\n"
                    + "values(?,?,?,?)");

            comando.setInt(1, nueva.getIdPaciente().getId());
            comando.setInt(2, nueva.getLegajoRecepcionista().getLegajo());
            comando.setString(3, nueva.getNombre());
            comando.setInt(4, nueva.getDuracion());

            comando.executeUpdate();

            comando.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public ArrayList<dtoVisitas> obtenerVisitas() {

        ArrayList<dtoVisitas> listaVisitas = new ArrayList<>();

        try {

            Connection conexion = DriverManager.getConnection(cadena);
            //CUANDO LA CONSULTA NO RECIBE PARAMETROS USAMOS EL STATEMENT
            java.sql.Statement comando = conexion.createStatement();
            ResultSet rs = comando.executeQuery("select p.Nombre as 'Nombre Paciente', v.Nombre as 'Nombre Visita', e.Nombre as 'Nombre Recepcionista', Duracion\n"
                    + "from Visitas v join Pacientes p \n"
                    + "on v.IdPaciente = p.IdPaciente\n"
                    + "join Empleados e on v.LegajoRecepcionista = e.Legajo");

            //UNA FILA POR CADA FILA RETORNADA POR EL SELECT
            while (rs.next()) {
                //PODEMOS LEER LA INFORMACION DE LAS TABLAS POR EL NOMBRE O NUMERO DE LA COLUMNA
                String nombrePaciente = rs.getString("Nombre Paciente");
                String nombreVisita = rs.getString("Nombre Visita");
                String nombreRecepcionista = rs.getString("Nombre Recepcionista");
                int duracion = rs.getInt("Duracion");

                dtoVisitas nueva = new dtoVisitas(nombrePaciente, nombreVisita, nombreRecepcionista, duracion);
                listaVisitas.add(nueva);
            }

            rs.close();
            comando.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listaVisitas;

    }

    public ArrayList<dtoReporte1> Reporte1() {

        ArrayList<dtoReporte1> listaPacientes = new ArrayList<>();

        try {

            Connection conexion = DriverManager.getConnection(cadena);
            //CUANDO LA CONSULTA NO RECIBE PARAMETROS USAMOS EL STATEMENT
            java.sql.Statement comando = conexion.createStatement();
            ResultSet rs = comando.executeQuery("select p.Nombre as 'Nombre', count(v.IdVisita) as 'Cantidad Visitas'\n"
                    + "from Visitas v join Pacientes p\n"
                    + "on v.IdPaciente = p.IdPaciente\n"
                    + "group by p.Nombre");

            //UNA FILA POR CADA FILA RETORNADA POR EL SELECT
            while (rs.next()) {
                //PODEMOS LEER LA INFORMACION DE LAS TABLAS POR EL NOMBRE O NUMERO DE LA COLUMNA
                String nombrePaciente = rs.getString("Nombre");
                int cantidad = rs.getInt("Cantidad Visitas");

                dtoReporte1 nueva = new dtoReporte1(nombrePaciente, cantidad);
                listaPacientes.add(nueva);
            }

            rs.close();
            comando.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listaPacientes;

    }

    public ArrayList<dtoReporte2> Reporte2() {

        ArrayList<dtoReporte2> listaPromedios = new ArrayList<>();

        try {

            Connection conexion = DriverManager.getConnection(cadena);
            //CUANDO LA CONSULTA NO RECIBE PARAMETROS USAMOS EL STATEMENT
            java.sql.Statement comando = conexion.createStatement();
            ResultSet rs = comando.executeQuery("select avg(Duracion)'Promedio'\n"
                    + "from Visitas\n"
                    + "where Duracion > 10");

            //UNA FILA POR CADA FILA RETORNADA POR EL SELECT
            while (rs.next()) {
                //PODEMOS LEER LA INFORMACION DE LAS TABLAS POR EL NOMBRE O NUMERO DE LA COLUMNA
                float promedio = rs.getFloat("Promedio");

                dtoReporte2 nueva = new dtoReporte2(promedio);
                listaPromedios.add(nueva);
            }

            rs.close();
            comando.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listaPromedios;

    }
    
    public ArrayList<Empleado> obtenerEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Empleados");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("Legajo");
                String nombre = rs.getString("Nombre");
                Empleado e = new Empleado(id, nombre);
                lista.add(e);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
     public ArrayList<Paciente> obtenerPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();

        try {
            Connection conexion = DriverManager.getConnection(cadena);
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from Pacientes");
            // Si el select devuelve una única fila, en lugar de while, se usa un if
            while (rs.next()) {
                int id = rs.getInt("IdPaciente");
                String nombre = rs.getString("Nombre");
                Paciente p = new Paciente(id, nombre);
                lista.add(p);
            }

            rs.close();
            st.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return lista;
    }

}
