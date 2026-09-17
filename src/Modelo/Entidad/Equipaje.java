/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Equipaje {
    
    private int id_equipaje;
    private double peso;
    private String estado;
    private String tipo;

    // Constructor vacío
    public Equipaje() {
    }

    // Constructor
    public Equipaje(int id_equipaje, double peso, String estado, String tipo) {
        this.id_equipaje = id_equipaje;
        this.peso = peso;
        this.estado = estado;
        this.tipo = tipo;
    }

    // Getter y Setter de idEquipaje
    public int getId_equipaje() {
        return id_equipaje;
    }

    public void setId_equipaje(int id_equipaje) {
        this.id_equipaje = id_equipaje;
    }

    // Getter y Setter de peso
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Getter y Setter de tipoEquipaje
    public String getEstado() {
        return estado;
    }

    public void setEsatdo(String estado) {
        this.estado = estado;
    }

    // Getter y Setter de tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
