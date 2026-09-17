/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Ruta {
    
     private int id_ruta;
    private String origen;
    private String destino;
    private int duracion;
    private int fk_aeropuerto;

    // Constructor vacío
    public Ruta() {
    }

    // Constructor
    public Ruta(int id_ruta, String origen, String destino, int duracion, int fk_aeropuerto) {
        this.id_ruta = id_ruta;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.fk_aeropuerto = fk_aeropuerto;
    }

    // Getter y Setter de idRuta
    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    // Getter y Setter de origen
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    // Getter y Setter de destino
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Getter y Setter de duracion
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public int getFk_aeropuerto() {
        return duracion;
    }

    public void setFk_aeropuerto(int fk_aeropuerto) {
        this.fk_aeropuerto = fk_aeropuerto;
    }
    
}
