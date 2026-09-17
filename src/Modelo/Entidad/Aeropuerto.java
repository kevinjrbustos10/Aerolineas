/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Aeropuerto {
    
    private int id_aeropuerto;
    private String nombre;
    private String codigo_lata;
    private String ciudad;
    private String pais;

    // Constructor vacío
    public Aeropuerto() {
    }

    // Constructor
    public Aeropuerto(int id_aeropuerto, String nombre, String codigo_lata,
                      String ciudad, String pais) {
        this.id_aeropuerto = id_aeropuerto;
        this.nombre = nombre;
        this.codigo_lata = codigo_lata;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    // Getter y Setter de idAeropuerto
    public int getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(int id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    // Getter y Setter de nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter de codigoLata
    public String getCodigo_lata() {
        return codigo_lata;
    }

    public void setCodigo_lata(String codigo_lata) {
        this.codigo_lata = codigo_lata;
    }

    // Getter y Setter de ciudad
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Getter y Setter de pais
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
