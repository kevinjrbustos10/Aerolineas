/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.AerolineaDAO;
import Modelo.DAO.AvionDAO;
import Modelo.Entidad.Avion;
import Vista.Admin.ifrmAvion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class AvionControlador implements ActionListener{
    
   private ifrmAvion vistaAvion;
    private AvionDAO daoAvion;
    private AerolineaDAO daoAerolinea; // Declarar DAO de Aerolínea

    public AvionControlador(ifrmAvion vista, AvionDAO dao) {
        this.vistaAvion = vista;
        this.daoAvion = dao;
        this.daoAerolinea = new AerolineaDAO(); // Inicializar DAO

        this.vistaAvion.btnGuardar.addActionListener(this);

        // Cargar combos y tabla al iniciar
        llenarComboAerolinea();
        listarAvion();
    }

    // Método para llenar el ComboBox dinámicamente
    public void llenarComboAerolinea() {
        ArrayList<String> aerolineas = daoAerolinea.listarNombresAerolineas();
        vistaAvion.cbxAerolinea.removeAllItems(); // Limpia elementos previos
        
        for (String nombre : aerolineas) {
            vistaAvion.cbxAerolinea.addItem(nombre);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAvion.btnGuardar) {
            guardarAvion();
        }
    }

    public void guardarAvion() {
        Avion v = new Avion();

        v.setModelo(vistaAvion.cbxModelo.getSelectedItem().toString());
        v.setCapacidad(vistaAvion.txtCapacidad.getText());
        v.setEstado(vistaAvion.cbxEstado.getSelectedItem().toString());
        v.setAño(vistaAvion.txtAño.getText());

        // Obtener el valor seleccionado del ComboBox
        v.setFk_aerolinea(vistaAvion.cbxAerolinea.getSelectedItem().toString());

        if (daoAvion.guardar(v)) {
            JOptionPane.showMessageDialog(null, "Avión guardado");
            listarAvion();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }

    public void listarAvion() {
        ArrayList<Avion> Lista = daoAvion.Listar();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("modelo");
        modelo.addColumn("capacidad");
        modelo.addColumn("estado");
        modelo.addColumn("año");
        modelo.addColumn("fk_aerolinea");

        for (Avion v : Lista) {
            Object datos[] = {
                v.getModelo(),
                v.getCapacidad(),
                v.getEstado(),
                v.getAño(),
                v.getFk_aerolinea()
            };
            modelo.addRow(datos);
        }
        vistaAvion.tblAvion.setModel(modelo);
    }
    
}
