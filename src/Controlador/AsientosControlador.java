/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.AsientosDAO;
import Modelo.DAO.PasajeroDAO;
import Modelo.Entidad.Asientos;
import Modelo.Entidad.Pasajero;
import Vista.Admin.ifrmAsientos;
import Vista.Admin.ifrmPasajero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class AsientosControlador implements ActionListener {
    
     private ifrmAsientos vistaAsientos;
    private AsientosDAO daoAsientos;
    
    
    public AsientosControlador(ifrmAsientos vista, AsientosDAO dao ){
        
        vistaAsientos = vista;
        daoAsientos = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaAsientos.btnGuardar) {
            
            guardarAsientos();
            
        }
        
    }
    
    public void guardarAsientos() {
        
        Asientos o = new Asientos();
        
        o.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        
        o.setDocumento(vistaPasajero.txtDocumento.getText());
        
        o.setNombre(vistaPasajero.txtNombre.getText());
        
        o.setApellido(vistaPasajero.txtApellido.getText());
        
        if (daoAsientos.guardar(o)) {
            
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarAsientos();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarAsientos(){
        
        ArrayList<Asientos> Lista = daoAsientos.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_asiento");
        modelo.addColumn("num_asiento");
        modelo.addColumn("clase");
        modelo.addColumn("estado");
        
        for (Asientos o : Lista){
            
            Object datos[] = {
                
                o.getId_asiento(),
                o.getNum_asiento(),
                o.getClase(),
                o.getEstado(),

            };
            modelo.addRow(datos);
        }
        vistaAsientos.tblAsientos.setModel(modelo);
    }
    
}
