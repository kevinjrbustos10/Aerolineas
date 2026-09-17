/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Avion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class AvionDAO {
    
    Connection con = Conectar.conexi();
    
    public ArrayList<Avion> Listar() {
        
     ArrayList<Avion> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM avion";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Avion v = new Avion();
             
             v. setModelo(
                     rs.getString("modelo"));
             
             v. setCapacidad(
                     rs.getString("capacidad"));
             
             v. setEstado(
                     rs.getString("estado"));
             
             v. setAño(
                     rs.getString("año"));
             
             v.setFk_aerolinea(
                     rs.getString("fk_aerolinea"));
             
             Lista.add(v);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Avion v){
        
        try{
            
            String sql = "INSERT INTO avion"
                   + "(modelo,capacidad,"
                   + "estado,año,fk_aerolinea)"
                   + " VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, v.getModelo());
            ps.setString(2, v.getCapacidad());
            ps.setString(3, v.getEstado());
            ps.setString(4, v.getAño());
            ps.setString(5, v.getFk_aerolinea());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
