/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.VuelosDAO;
import Modelo.Entidad.Vuelos;
import Vista.Admin.ifrmVuelos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class VuelosControlador implements ActionListener {
    
     private ifrmVuelos vistaVuelos;
    private VuelosDAO daoVuelos;
    
    
    public VuelosControlador(ifrmVuelos vista, VuelosDAO dao ){
        
        vistaVuelos = vista;
        daoVuelos = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaVuelos.btnGuardar) {
            
            guardarVuelos();
            
        }
        
    }
    
    public void guardarPasajero() {
        
        Vuelos v = new Vuelos();
        
        v.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        
        v.setDocumento(vistaPasajero.txtDocumento.getText());
        
        v.setNombre(vistaPasajero.txtNombre.getText());
        
        v.setApellido(vistaPasajero.txtApellido.getText());
        
        if (daoVuelos.guardar(p)) {
            
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarVuelos();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarVuelos(){
        
        ArrayList<Vuelos> Lista = daoVuelos.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_vuelo");
        modelo.addColumn("fecha_salida");
        modelo.addColumn("fecha_llegada");
        modelo.addColumn("hora_llegada");
        modelo.addColumn("hora_salida");
        modelo.addColumn("estado");

        
        for (Vuelos v : Lista){
            
            Object datos[] = {
                
                v.getId_vuelo(),
                v.getFecha_salida(),
                v.getFecha_llegada(),
                v.getHora_llegada(),
                v.getHora_salida(),
                v.getEstado(),

            };
            modelo.addRow(datos);
        }
        vistaVuelos.tblVuelos.setModel(modelo);
    }
    
}
