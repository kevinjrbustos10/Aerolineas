/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Asientos {
    
    private int id_asiento;
    private String num_asiento;
    private String clase;
    private String estado;

    // Constructor vacío
    public Asientos() {
    }

    // Constructor
    public Asientos(int id_asiento, String num_asiento, String clase, String estado) {
        this.id_asiento = id_asiento;
        this.num_asiento = num_asiento;
        this.clase = clase;
        this.estado = estado;
    }

    // Getter y Setter de idAsiento
    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    // Getter y Setter de numAsiento
    public String getNum_asiento() {
        return num_asiento;
    }

    public void setNum_asiento(String num_asiento) {
        this.num_asiento = num_asiento;
    }

    // Getter y Setter de clase
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    // Getter y Setter de estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
