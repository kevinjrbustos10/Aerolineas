/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.TiqueteDAO;
import Modelo.Entidad.Tiquete;
import Vista.Admin.ifrmTiquete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class TiqueteControlador implements ActionListener {
    
     
    private ifrmTiquete vistaTiquete;
    private TiqueteDAO daoTiquete;
    
    
    public TiqueteControlador(ifrmTiquete vista, TiqueteDAO dao ){
        
        vistaTiquete = vista;
        daoTiquete = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaTiquete.btnGuardar) {
            
            guardarTiquete();
            
        }
        
    }
    
    public void guardarTiquete() {
        
        Tiquete t = new Tiquete();
        
        t.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        
        t.setDocumento(vistaPasajero.txtDocumento.getText());
        
        t.setNombre(vistaPasajero.txtNombre.getText());
        
        t.setApellido(vistaPasajero.txtApellido.getText());
        
        if (daoTiquete.guardar(t)) {
            
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarTiquete();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarTiquete(){
        
        ArrayList<Tiquete> Lista = daoTiquete.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_tiquete");
        modelo.addColumn("fecha_emision");
        modelo.addColumn("reserva");
        modelo.addColumn("metodo_Pago");
        modelo.addColumn("valor");
        
        for (Tiquete t : Lista){
            
            Object datos[] = {
                
                t.getId_tiquete(),
                t.getFecha_emision(),
                t.getReserva(),
                t.getMetodo_pago(),
                t.getValor(),


            };
            modelo.addRow(datos);
        }
        vistaTiquete.tblTiquete.setModel(modelo);
    }
    
}
