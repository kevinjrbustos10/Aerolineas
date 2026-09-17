/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Aeropuerto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class AeropuertoDAO {
    
    Connection con = Conectar.conexi();
    
    public ArrayList<Aeropuerto> Listar() {
        
     ArrayList<Aeropuerto> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM aeropuerto";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Aeropuerto a = new Aeropuerto();
             
             a.setId_aeropuerto(
                     rs.getInt("id_aeropuerto"));
             
             a. setNombre(
                     rs.getString("nombre"));
             
             a. setCodigo_lata(
                     rs.getString("codigo_lata"));
             
             a. setCiudad(
                     rs.getString("ciudad"));
             
             a. setPais(
                     rs.getString("pais"));

             Lista.add(a);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
    
}


public boolean guardar(Aeropuerto a){
        
        try{
            
            String sql = "INSERT INTO aeropuerto"
                   + "(id_aeropuerto,nombre,"
                   + "codigo_lata,ciudad,pais)"
                   + " VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, a.getId_aeropuerto());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getCodigo_lata());
            ps.setString(4, a.getCiudad());
            ps.setString(5, a.getPais());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
}




