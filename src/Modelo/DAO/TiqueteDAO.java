/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;

import Modelo.Entidad.Tiquete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class TiqueteDAO {
    
     
    Connection con = Conectar.conexi();
    
    public ArrayList<Tiquete> Listar() {
        
     ArrayList<Tiquete> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM tiquete";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Tiquete t = new Tiquete();
             
             t. setId_tiquete(
                     rs.getInt("id_tiquete"));
             
             t. setFecha_emision(
                     rs.getDate("fecha-emision"));
             
             t. setReserva(
                     rs.getString("reserva"));
             
             t. setMetodo_pago(
                     rs.getString("metodo_pado"));
             
             t. setValor(
                     rs.getBigDecimal("valor"));
         
             Lista.add(t);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    public boolean guardar(Tiquete t){
        
        try{
            
            String sql = "INSERT INTO tiquete"
                   + "(id_tiquete,fecha-emision,"
                   + "reserva,metodo_pado,valor)"
                   + " VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, t.getId_tiquete());
            ps.setDate(2, new java.sql.Date(t.getFecha_emision().getTime()));
            ps.setString(3, t.getReserva());
            ps.setString(4, t.getMetodo_pago());
            ps.setBigDecimal(5, t.getValor());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
