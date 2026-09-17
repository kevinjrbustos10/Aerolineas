/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class RutaDAO {
    
    Connection con = Conectar.conexi();
    
    public ArrayList<Ruta> Listar() {
        
     ArrayList<Ruta> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM ruta";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Ruta r = new Ruta();
             
             r. setId_ruta(
                     rs.getInt("id_ruta"));
             
             r. setOrigen(
                     rs.getString("origen"));
             
             r. setDestino(
                     rs.getString("destino"));
             
             r. setDuracion(
                     rs.getInt("duracion"));
             
             r.setFk_aeropuerto(
                     rs.getInt("fk_aeropuerto"));
             
             Lista.add(r);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Ruta r){
        
        try{
            
            String sql = "INSERT INTO ruta"
                   + "(id_ruta,origen,"
                   + "destino,duracion,fk_aeropuerto)"
                   + " VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
           
            ps.setString(1, r.getOrigen());
            ps.setString(2, r.getDestino());
            ps.setInt(3, r.getDuracion());
            ps.setInt(4, r.getFk_aeropuerto());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
