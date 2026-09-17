/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Equipaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class EquipajeDAO {
    
     Connection con = Conectar.conexi();
    
    public ArrayList<Equipaje> Listar() {
        
     ArrayList<Equipaje> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM equipaje";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Equipaje e = new Equipaje();
             
             e. setId_equipaje(
                     rs.getInt("id_equipaje"));
             
             e. setPeso(
                     rs.getDouble("peso"));
             
             e. setEsatdo(
                     rs.getString("estado"));
             
             e. setTipo(
                     rs.getString("tipo"));
             
             

             Lista.add(e);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Equipaje e){
        
        try{
            
            String sql = "INSERT INTO equipaje"
                   + "(id_equipaje,peso,"
                   + "estado,tipo)"
                   + " VALUES (?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, e.getId_equipaje());
            ps.setDouble(2, e.getPeso());
            ps.setString(3, e.getEstado());
            ps.setString(4, e.getTipo());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (Exception ex) {
    System.out.println(ex);
    return false;
}
    }
    
}
