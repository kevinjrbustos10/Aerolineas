/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Aerolinea {
    
    private String nombre_aerolinea;
    private String telefono;
    private String correo;

    // Constructor vacío
    public Aerolinea() {
    }

    // Constructor
    public Aerolinea(String nombre_aerolinea, String telefono, String correo) {
        this.nombre_aerolinea = nombre_aerolinea;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getter y Setter de nombreAerolinea
    public String getNombre_aerolinea() {
        return nombre_aerolinea;
    }

    public void setNombre_aerolinea(String nombre_aerolinea) {
        this.nombre_aerolinea = nombre_aerolinea;
    }

    // Getter y Setter de telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getter y Setter de correo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
