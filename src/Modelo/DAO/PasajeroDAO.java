/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import Modelo.Conexion.Conectar; 
import Modelo.Entidad.Pasajero;
import java.util.ArrayList;
import java.sql.PreparedStatement;


/**
 *
 * @author Aprendiz
 */
public class PasajeroDAO {
    
    Connection con = Conectar.conexi();
    
    public ArrayList<Pasajero> Listar() {
        ArrayList<Pasajero> Lista = new ArrayList<>();
        
        try { 
            String sql = "SELECT * FROM pasajero";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Pasajero p = new Pasajero();
                p.setDocumento(rs.getString("documento"));
                p.setTipo_documento(rs.getString("tipo_documento"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setNacionalidad(rs.getString("nacionalidad"));
                p.setTelefono(rs.getString("telefono"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setCorreo(rs.getString("correo"));
                
                Lista.add(p);
            }
        } catch (Exception e){
            System.out.print(e);
        }
        
        return Lista;
    }
    
    public boolean guardar(Pasajero p){
        try{
            // Se corrigió el punto entre los últimos dos comodines (?,?)
            String sql = "INSERT INTO pasajero"
                   + " (tipo_documento, documento, nombre, apellido, nacionalidad, telefono, fecha_nacimiento, correo)"
                   + " VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, p.getTipo_documento());
            ps.setString(2, p.getDocumento());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setString(5, p.getNacionalidad());
            ps.setString(6, p.getTelefono());
            ps.setDate(7, new java.sql.Date(p.getFecha_nacimiento().getTime()));
            ps.setString(8, p.getCorreo());
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e){
            System.out.println("Error al guardar: " + e);
            return false;
        }
    }

    public boolean modificar(Pasajero p){
        String sql = "UPDATE pasajero SET tipo_documento=?, nombre=?, apellido=? WHERE documento=?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, p.getTipo_documento());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellido());
        ps.setString(4, p.getDocumento()); // WHERE documento = ?
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e){
            System.out.println("Error al modificar: " + e);
            return false;
        }
    }

    public boolean eliminar(String documento){
        try {
            String sql = "DELETE FROM pasajero WHERE documento=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            
            ps.executeUpdate();
            return true;
            
        } catch(Exception e){
            System.out.println("Error al eliminar: " + e);
            return false;
        }
    }
    
}

