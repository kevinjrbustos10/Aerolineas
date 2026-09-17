/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Asientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class AsientosDAO {
    
     Connection con = Conectar.conexi();
    
    public ArrayList<Asientos> Listar() {
        
     ArrayList<Asientos> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM asientos";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Asientos o = new Asientos();
             
             o. setId_asiento(
                     rs.getInt("id_asiento"));
             
             o. setNum_asiento(
                     rs.getString("num_asiento"));
             
             o. setClase(
                     rs.getString("clase"));
             
             o. setEstado(
                     rs.getString("estado"));
             
             Lista.add(o);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Asientos o){
        
        try{
            
            String sql = "INSERT INTO asientos"
                   + "(id_asiento,num_asiento,"
                   + "clase,estado)"
                   + " VALUES (?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, o.getId_asiento());
            ps.setString(2, o.getNum_asiento());
            ps.setString(3, o.getClase());
            ps.setString(4, o.getEstado());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
