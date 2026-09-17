/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

// Importaciones según la estructura de tu proyecto

import Modelo.DAO.AerolineaDAO;
import Modelo.DAO.AeropuertoDAO;
import Modelo.DAO.AvionDAO;
import Modelo.DAO.PasajeroDAO;
import Vista.Admin.MenuAdmin;
import Vista.Admin.ifrmAerolinea;
import Vista.Admin.ifrmAeropuerto;
import Vista.Admin.ifrmAvion;
import Vista.Admin.ifrmPasajero;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aprendiz
 */
public class MenuAdminControlador implements ActionListener{
    
     private MenuAdmin vistaMenu;

    public MenuAdminControlador(MenuAdmin vista) {
        this.vistaMenu = vista;

        // Registrar los botones de la vista
        this.vistaMenu.btnAerolinea.addActionListener(this);
        this.vistaMenu.btnAvion.addActionListener(this);
        this.vistaMenu.btnPasajeros.addActionListener(this);
        this.vistaMenu.btnAeropuerto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("Botón presionado: " + e.getActionCommand());

        // 1. Módulo Aerolíneas
        if (e.getSource() == vistaMenu.btnAerolinea) {
            ifrmAerolinea vistaAerolinea = new ifrmAerolinea();
            AerolineaDAO daoAerolinea = new AerolineaDAO();
            AerolineaControlador controlAerolinea = new AerolineaControlador(vistaAerolinea, daoAerolinea);
            controlAerolinea.listarAerolinea();

            mostrarModulo(vistaAerolinea);
        }

        // 2. Módulo Aviones
        else if (e.getSource() == vistaMenu.btnAvion) {
            ifrmAvion vistaAvion = new ifrmAvion();
            AvionDAO daoAvion = new AvionDAO();
            AvionControlador controlAvion = new AvionControlador(vistaAvion, daoAvion);
            // controlAvion.listarAviones(); // Llama a tu método de listar

            mostrarModulo(vistaAvion);
        }

        // 3. Módulo Pasajeros
        else if (e.getSource() == vistaMenu.btnPasajeros) {
            ifrmPasajero vistaPasajero = new ifrmPasajero();
            PasajeroDAO daoPasajero = new PasajeroDAO();
            PasajeroControlador controlPasajero = new PasajeroControlador(vistaPasajero, daoPasajero);
            controlPasajero.listarPasajero();

            mostrarModulo(vistaPasajero);
        }
        
         // 1. Módulo Aerolíneas
        if (e.getSource() == vistaMenu.btnAeropuerto) {
            ifrmAeropuerto vistaAeropuerto = new ifrmAeropuerto();
            AeropuertoDAO daoAeropuerto = new AeropuertoDAO();
            AeropuertoControlador controlAeropuerto = new AeropuertoControlador(vistaAeropuerto, daoAeropuerto);
            controlAeropuerto.listarAeropuerto();

            mostrarModulo(vistaAeropuerto);
        }
    }

    /**
     * Método genérico para limpiar el panel e incrustar el JInternalFrame
     */
    private void mostrarModulo(JInternalFrame iframe) {
        
        // 1. Quitar la barra superior
    ((BasicInternalFrameUI) iframe.getUI()).setNorthPane(null);
    iframe.setBorder(null);

    // 2. Limpiar el contenedor
    vistaMenu.PanelAdmin.removeAll();
    vistaMenu.PanelAdmin.setLayout(new BorderLayout());

    // 3. Forzar el tamaño del JInternalFrame al tamaño del panel contenedor
    iframe.setSize(vistaMenu.PanelAdmin.getSize());
    
    // 4. Agregar y actualizar
    vistaMenu.PanelAdmin.add(iframe, BorderLayout.CENTER);
    iframe.setVisible(true);

    vistaMenu.PanelAdmin.revalidate();
    vistaMenu.PanelAdmin.repaint();
        
        
        
    }
    
}
