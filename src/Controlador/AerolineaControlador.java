/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.AerolineaDAO;
import Modelo.Entidad.Aerolinea;
import Vista.Admin.ifrmAerolinea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class AerolineaControlador implements ActionListener {
    
    private ifrmAerolinea vistaAerolinea;
    private AerolineaDAO daoAerolinea;
    
    
    public AerolineaControlador(ifrmAerolinea vista, AerolineaDAO dao ){
        
        vistaAerolinea = vista;
        daoAerolinea = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaAerolinea.btnGuardar) {
            
            guardarAerolinea();
            
        }
        
    }
    
    public void guardarAerolinea() {
        
        Aerolinea a = new Aerolinea();
        
        a.setNombre_aerolinea(vistaAerolinea.txtNombre.getText());
        
        a.setTelefono(vistaAerolinea.txtTelefono.getText());
        
        a.setCorreo(vistaAerolinea.txtCorreo.getText());
        
        
        if (daoAerolinea.guardar(a)) {
            
            JOptionPane.showMessageDialog(null, "Aerolinea guardado");
            listarAerolinea();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarAerolinea(){
        
        ArrayList<Aerolinea> Lista = daoAerolinea.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("nombre_aerolinea");
        modelo.addColumn("telefono");
        modelo.addColumn("Correo");
        
        for (Aerolinea a : Lista){
            
            Object datos[] = {
                
                a.getNombre_aerolinea(),
                a.getTelefono(),
                a.getCorreo()
            };
            modelo.addRow(datos);
        }
        vistaAerolinea.tblAerolinea.setModel(modelo);
    }
    
}
