/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @author Aprendiz
 */
public class Vuelos {
    
     private int id_vuelo;
    private Date fecha_salida;
    private Date fecha_llegada;
    private Time hora_llegada;
    private Time hora_salida;
    private String estado;

    // Constructor vacío
    public Vuelos() {
    }

    // Constructor
    public Vuelos(int id_vuelo, Date fecha_salida, Date fecha_llegada,
                 Time hora_llegada, Time hora_salida, String estado) {
        this.id_vuelo = id_vuelo;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.hora_llegada = hora_llegada;
        this.hora_salida = hora_salida;
        this.estado = estado;
    }

    // Getter y Setter de idVuelo
    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    // Getter y Setter de fechaSalida
    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    // Getter y Setter de fechaLlegada
    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    // Getter y Setter de horaLlegada
    public Time getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    // Getter y Setter de horaSalida
    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    // Getter y Setter de estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
