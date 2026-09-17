/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.AeropuertoDAO;
import Modelo.Entidad.Aeropuerto;
import Vista.Admin.ifrmAeropuerto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class AeropuertoControlador implements ActionListener {
    
     private ifrmAeropuerto vistaAeropuerto;
    private AeropuertoDAO daoAeropuerto;
    
    
    public AeropuertoControlador(ifrmAeropuerto vista, AeropuertoDAO dao ){
        
        vistaAeropuerto = vista;
        daoAeropuerto = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaAeropuerto.btnGuardar) {
            
            guardarAeropuerto();
            
        }
        
    }
    
    public void guardarAeropuerto() {
        
        Aeropuerto a = new Aeropuerto();
        
        a.setCodigo_lata(vistaAeropuerto.cbxTipo.getSelectedItem().toString());
        
        a.setNombre(vistaAeropuerto.txtNombre.getText());
        
        a.setCiudad(vistaAeropuerto.txtCiudad.getText());
        
        a.setPais(vistaAeropuerto.txtPais.getText());
        
        if (daoAeropuerto.guardar(a)) {
            
            JOptionPane.showMessageDialog(null, "Aeropuerto guardado");
            listarAeropuerto();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarAeropuerto(){
        
        ArrayList<Aeropuerto> Lista = daoAeropuerto.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_aeropuerto");
        modelo.addColumn("nombre");
        modelo.addColumn("codigo_lata");
        modelo.addColumn("Ciudad");
        modelo.addColumn("pais");
        
        
        for (Aeropuerto a : Lista){
            
            Object datos[] = {
                
                a.getId_aeropuerto(),
                a.getNombre(),
                a.getCodigo_lata(),
                a.getCiudad(),
                a.getPais(),
            };
            modelo.addRow(datos);
        }
        vistaAeropuerto.tblAeropuerto.setModel(modelo);
    }
    
}
