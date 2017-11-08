/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;

import Objetos.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class Codigo_Base_Datos {
    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    static String jdbc = "jdbc:postgresql://localhost:5432/usuario";

    
    public boolean Agregar_Enviar_Base_Datos(Persona persona) {
        boolean agregado = false;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "INSERT INTO usuarios VALUES (?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setInt(1, persona.getCedula());
            pst.setString(2, persona.getNombre());
            pst.setInt(3, persona.getEdad());
            pst.setBoolean(4, persona.getSexo());
            pst.executeUpdate();
            conn.close();
            agregado = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se repite el numero de cedula");
        }
        return agregado;
    }
    
    public boolean Modificar(Persona persona){
        boolean modificado = false;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "UPDATE usuarios SET nombre = ?,edad = ?,sexo = ? WHERE cedula = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, persona.getNombre());
            pst.setInt(2, persona.getEdad());
            pst.setBoolean(3, persona.getSexo());
            pst.setInt(4, persona.getCedula());
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modificado;
    }

    public Persona Buscar_Ced(String cedula){
        Persona persona = null;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "SELECT * FROM usuarios WHERE CAST(cedula AS VARCHAR) ILIKE '"+cedula+"%'";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                persona = new Persona(rs.getInt("cedula"),rs.getString("nombre"),rs.getInt("edad"),rs.getBoolean("sexo"));
                break;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persona;
    }
    
    public ArrayList<Persona> Buscar_Personas(String cedula){
        ArrayList<Persona> lista_personas = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "SELECT * FROM usuarios WHERE CAST(cedula AS VARCHAR) ILIKE '"+cedula+"%'";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getBoolean("sexo"));
                lista_personas.add(persona);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_personas;
    }
    public ArrayList<Persona> Buscar_Personas(){
        ArrayList<Persona> lista_personas = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "SELECT * FROM usuarios";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getBoolean("sexo"));
                lista_personas.add(persona);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_personas;
    }
    public ArrayList<Persona> Buscar_edad(int edad_min, int edad_max){
        ArrayList<Persona> lista_personas = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "SELECT * FROM usuarios WHERE edad >= "+edad_min+" and edad <= "+edad_max+";";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getBoolean("sexo"));
                lista_personas.add(persona);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_personas;
    }
    
    public ArrayList Buscar_genero_edad(boolean sexo,int edad){
        ArrayList<Persona> lista_personas = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            query = "SELECT * FROM usuarios WHERE edad = "+edad+" and sexo = "+sexo+";";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getBoolean("sexo"));
                lista_personas.add(persona);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Codigo_Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_personas;
    }
    
}
