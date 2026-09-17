/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Vuelos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class VuelosDAO {
    
     Connection con = Conectar.conexi();
    
    public ArrayList<Vuelos> Listar() {
        
     ArrayList<Vuelos> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM vuelos";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Vuelos V = new Vuelos();
             
             V. setId_vuelo(
                     rs.getInt("id_vuelo"));
             
             V. setFecha_salida(
                     rs.getDate("fecha_salida"));
             
             V. setFecha_llegada(
                     rs.getDate("fecha_llegada"));
             
             V. setHora_llegada(
                     rs.getTime("hora_llegada"));
             
             V. setHora_salida(
                     rs.getTime("hora_salida"));
             
             V. setEstado(
                     rs.getString("estado"));
             
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Vuelos v){
        
        try{
            
            String sql = "INSERT INTO vuelos"
                   + "(id_vuelo,fecha_salida,fecha_llegada"
                   + "hora_llegada,hora_salida,estado)"
                   + " VALUES (?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(v.getFecha_salida().getTime()));
            ps.setDate(2, new java.sql.Date(v.getFecha_llegada().getTime()));
            ps.setTime(3, v.getHora_llegada());
            ps.setTime(4, v.getHora_salida());
            ps.setString(4, v.getEstado());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
