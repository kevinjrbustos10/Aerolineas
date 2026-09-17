/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aprendiz
 */
public class Conectar {
    
     private static String ruta = "jdbc:mysql://localhost:3306/gestiondevuelos";
    private static String user = "Kevin";
    private static String pass = "Futbol+Deus10";

    public static Connection conexion;
    public static Statement consulta;
    public static Connection conexi() {
        try {
            conexion = DriverManager.getConnection(ruta, user, pass);
            consulta = conexion.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public static Statement consultas() {
        return consulta;
    }
    
}
