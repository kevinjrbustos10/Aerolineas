    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.PasajeroDAO;
import Modelo.DAO.RutaDAO;
import Modelo.Entidad.Pasajero;
import Modelo.Entidad.Ruta;
import Vista.Admin.ifrmPasajero;
import Vista.Admin.ifrmRuta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class RutaControlador implements ActionListener {
    
    private ifrmRuta vistaRuta;
    private RutaDAO daoRuta;
    
    
    public RutaControlador(ifrmRuta vista, RutaDAO dao ){
        
        vistaRuta = vista;
        daoRuta = dao;
        
        vista.btnGuardar.addActionListener((ActionListener) this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaRuta.btnGuardar) {
            
            guardarPasajero();
            
        }
        
    }
    
    public void guardarRuta() {
        
        Ruta r = new Ruta();
        
        r.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        
        r.setDocumento(vistaPasajero.txtDocumento.getText());
        
        r.setNombre(vistaPasajero.txtNombre.getText());
        
        r.setApellido(vistaPasajero.txtApellido.getText());
        
        if (daoRuta.guardar(r)) {
            
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarRuta();
            
        }else {
            
            JOptionPane.showMessageDialog(null, "Error al guardar");
            
        }
        
    }
    
    
    public void listarRuta(){
        
        ArrayList<Ruta> Lista = daoRuta.Listar();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id_ruta");
        modelo.addColumn("origen");
        modelo.addColumn("destino");
        modelo.addColumn("duracion");
        modelo.addColumn("fk_aeropuerto");

        
        for (Ruta r : Lista){
            
            Object datos[] = {
                
                r.getId_ruta(),
                r.getOrigen(),
                r.getDestino(),
                r.getDuracion(),
                r.getFk_aeropuerto(),
            };
            modelo.addRow(datos);
        }
        vistaRuta.tblRuta.setModel(modelo);
    }
    
}
