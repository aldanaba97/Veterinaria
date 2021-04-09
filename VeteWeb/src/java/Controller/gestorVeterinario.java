/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.cliente;
import Models.especialidad;
import Models.mascotas;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aldana
 */
public class gestorVeterinario {

    public gestorVeterinario() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gestorVeterinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Insertar(mascotas m) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            PreparedStatement st = conn.prepareStatement("insert into Mascotas (Nombre, idCliente, idEspecie, Nacimiento) values (?,?,?,?)");
            st.setString(1, m.getNombre());
            st.setInt(2, m.getC().getId_cliente());
            st.setInt(3, m.getE().getId_especialidad());
            st.setInt(4, m.getNacimiento());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<mascotas> listadoMascotas() {
        ArrayList<mascotas> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select m.Nombre, c.Nombre, Telefono\n"
                    + "from Clientes c join Mascotas m on c.IdCliente = m.IdCliente\n"
                    + "order by c.Nombre");
            while (rs.next()) {
                String nombre = rs.getString(1);
                String nombreCliente = rs.getString(2);
                String telefono = rs.getString(3);

                especialidad e = new especialidad(0, "");
                cliente c = new cliente(nombreCliente, telefono, 0);
                mascotas m = new mascotas(0, nombre, 0, e, c);

                lista.add(m);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }

    public ArrayList<especialidad> obtenerEspecialidad() {
        ArrayList<especialidad> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Especies");
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);

                especialidad e = new especialidad(codigo, nombre);
                lista.add(e);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }

    public ArrayList<cliente> obtenerCliente() {
        ArrayList<cliente> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Clientes");
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String telefono = rs.getString(3);

                cliente c = new cliente(nombre, telefono, codigo);
                lista.add(c);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }

    public int promedioEdad() {
        int promedio = 0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select sum(year(getdate()) - Nacimiento) / COUNT(*) promedio\n"
                    + "from Mascotas");
            if (rs.next()) {
                promedio = rs.getInt(1);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promedio;

    }

    public ArrayList<mascotas> listadoMascotasxEspecie() {
        ArrayList<mascotas> lista = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://ALDANA-PC:1433;databaseName=Veterinaria", "sa", "aldana97");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select m.Nombre, c.Nombre, Nacimiento\n"
                    + "from   Mascotas m join Clientes c on c.IdCliente = m.IdCliente\n"
                    + "join Especies e on e.IdEspecie = m.IdEspecie\n"
                    + "where e.Denominacion like 'Perro%'");
            while (rs.next()) {
                String nombre = rs.getString(1);
                String nombreCliente = rs.getString(2);
                int nacimiento = rs.getInt(3);

                especialidad e = new especialidad(0, "");
                cliente c = new cliente(nombreCliente, "", 0);
                mascotas m = new mascotas(0, nombre, nacimiento, e, c);

                lista.add(m);
            }

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }
}
