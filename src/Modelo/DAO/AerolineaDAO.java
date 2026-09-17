/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Conexion.Conectar;
import Modelo.Entidad.Aerolinea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class AerolineaDAO {
    
    Connection con = Conectar.conexi();
    
    public ArrayList<Aerolinea> Listar() {
        
     ArrayList<Aerolinea> Lista = new ArrayList<>();
     
     try { 
         String sql = "SELECT * FROM aerolinea";
         
         Statement st = con.createStatement();
         
         ResultSet rs = st.executeQuery(sql);
         
         while (rs.next()){
            
             Aerolinea a = new Aerolinea();
             
             a. setNombre_aerolinea(
                     rs.getString("nombre_aerolinea"));
             
             a. setTelefono(
                     rs.getString("telefono"));
             
             a. setCorreo(
                     rs.getString("correo"));
             Lista.add(a);
         
         }
     }catch (Exception e){
         
         System.out.print(e);
         
     }
     
     return Lista;
        
    }
    
    //Metodo del comoBox de Aerolinea
    public ArrayList<String> listarNombresAerolineas() {
    ArrayList<String> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT nombre_aerolinea FROM aerolinea";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            // Añade directamente el texto del nombre a la lista
            lista.add(rs.getString("nombre_aerolinea"));
        }
    } catch (Exception e) {
        System.out.println("Error al cargar nombres: " + e);
    }

    return lista;
}
    
    public boolean guardar(Aerolinea a){
        
        try{
            
            String sql = "INSERT INTO aerolinea"
                   + "(nombre_aerolinea,telefono,"
                   + "correo)"
                   + " VALUES (?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, a.getNombre_aerolinea());
            ps.setString(2, a.getTelefono());
            ps.setString(3, a.getCorreo());
            
            ps.executeUpdate();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
}
