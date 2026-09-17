/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.EquipajeDAO;
import Modelo.Entidad.Equipaje;
import Vista.Admin.ifrmEquipaje;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class EquipajeControlador implements ActionListener {
    
     private ifrmEquipaje vistaEquipaje;
    private EquipajeDAO daoEquipaje;
    
    
    public EquipajeControlador(ifrmEquipaje vista, EquipajeDAO dao ){
        
        vistaEquipaje = vista;
        daoEquipaje = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaEquipaje.btnGuardar) {
            
            guardarEquipaje();
            
        }
        
    }
    
    public void guardarEquipaje() {
        
        Equipaje q = new Equipaje();
        
        q.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        
        q.setDocumento(vistaPasajero.txtDocumento.getText());
        
        q.setNombre(vistaPasajero.txtNombre.getText());
        
        q.setApellido(vistaPasajero.txtApellido.getText());
        
        if (daoEquipaje.guardar(p)) {
            
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarEquipaje();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarEquipaje(){
        
        ArrayList<Equipaje> Lista = daoEquipaje.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_equipaje");
        modelo.addColumn("peso");
        modelo.addColumn("estado");
        modelo.addColumn("tipo");
        
        for (Equipaje q : Lista){
            
            Object datos[] = {
                
                q.getId_equipaje(),
                q.getPeso(),
                q.getEstado(),
                q.getTipo(),

            };
            modelo.addRow(datos);
        }
        vistaEquipaje.tblEquipaje.setModel(modelo);
    }
    
}
