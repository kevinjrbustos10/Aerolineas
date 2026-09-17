/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @author Aprendiz
 */
public class Tiquete {
    
    private int id_tiquete;
    private Date fecha_emision;
    private String reserva;
    private String metodo_Pago;
    private BigDecimal valor;

    // Constructor vacío
    public Tiquete() {
    }

    // Constructor
    public Tiquete(int id_tiquete, Date fecha_emision, String reserva,
        String metodo_Pago, BigDecimal valor) {

    this.id_tiquete = id_tiquete;
    this.fecha_emision = fecha_emision;
    this.reserva = reserva;
    this.metodo_Pago = metodo_Pago;
    this.valor = valor;
}

    // Getter y Setter de idTiquete
    public int getId_tiquete() {
        return id_tiquete;
    }

    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }

    // Getter y Setter de fechaEmision
    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    // Getter y Setter de reserva
    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    // Getter y Setter de metodoPago
    public String getMetodo_pago() {
        return metodo_Pago;
    }

    public void setMetodo_pago(String metodo_Pago) {
        this.metodo_Pago = metodo_Pago;
    }
    
    public BigDecimal getValor() {
    return valor;
}

public void setValor(BigDecimal valor) {
    this.valor = valor;
}
}
