/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Avion {
    
    private String modelo;
    private String capacidad;
    private String estado;
    private String año;
    private String fk_aerolinea;
    
     public Avion() {
    }
    
    // Constructor
    public Avion(String modelo, String capacidad, String estado, String año, String fk_aerolinea ) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
        this.año = año;
        this.fk_aerolinea = fk_aerolinea;
    }

    // Getter y Setter de modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter y Setter de capacidad
    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    // Getter y Setter de estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getter y Setter de año
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    

public String getFk_aerolinea() {
    return fk_aerolinea;
}

public void setFk_aerolinea(String fk_aerolinea) {
    this.fk_aerolinea = fk_aerolinea;
}
}
    
    
