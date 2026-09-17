/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Entidad;

/**
 *
 * @author Aprendiz
 */
public class Usuario {
    
     private int idusuario;
    private String usuario;
    private String clave;
    private String rol;
    private String estado;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor
    public Usuario(int idusuario, String usuario, String clave, String rol, String estado) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.estado = estado;
    }

    // Getter y Setter de idUsuario
    public int getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idusuario = idusuario;
    }

    // Getter y Setter de usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getter y Setter de clave
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    // Getter y Setter de rol
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Getter y Setter de estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
