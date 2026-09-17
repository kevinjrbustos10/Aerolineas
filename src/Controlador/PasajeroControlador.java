/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.PasajeroDAO;
import Modelo.Entidad.Pasajero;
import Vista.Admin.ifrmPasajero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class PasajeroControlador implements ActionListener {
    
   private ifrmPasajero vistaPasajero;
    private PasajeroDAO daoPasajero;

    public PasajeroControlador(ifrmPasajero vista, PasajeroDAO dao) {
        vistaPasajero = vista;
        daoPasajero = dao;
        
        // Escuchadores de botones
        vista.btnGuardar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        
        // Escuchador de clic sobre la tabla
        vista.tblPasajero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosFormulario();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPasajero.btnGuardar) {
            guardarPasajero();
        } else if (e.getSource() == vistaPasajero.btnEditar) {
            editarPasajero();
        } else if (e.getSource() == vistaPasajero.btnEliminar) {
            eliminarPasajero();
        }
    }

    // Pasa los datos de la fila seleccionada a las cajas de texto y combobox
    private void cargarDatosFormulario() {
        int fila = vistaPasajero.tblPasajero.getSelectedRow();
        if (fila >= 0) {
            vistaPasajero.txtDocumento.setText(vistaPasajero.tblPasajero.getValueAt(fila, 0).toString());
            vistaPasajero.cbxTipo.setSelectedItem(vistaPasajero.tblPasajero.getValueAt(fila, 1).toString());
            vistaPasajero.txtNombre.setText(vistaPasajero.tblPasajero.getValueAt(fila, 2).toString());
            vistaPasajero.txtApellido.setText(vistaPasajero.tblPasajero.getValueAt(fila, 3).toString());
            // Asigna los demás campos si los tienes en la vista (Nacionalidad, Teléfono, Correo, etc.)
        }
    }

    public void editarPasajero() {
        int fila = vistaPasajero.tblPasajero.getSelectedRow();
        
        // Validación: Verifica si no se ha seleccionado ninguna fila (-1 indica sin selección)
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            return;
        }

        Pasajero p = obtenerDatosFormulario();
        if (daoPasajero.modificar(p)) {
            JOptionPane.showMessageDialog(null, "Pasajero actualizado exitosamente");
            listarPasajero();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar pasajero");
        }
    }

    public void guardarPasajero() {
        Pasajero p = obtenerDatosFormulario();
        if (daoPasajero.guardar(p)) {
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            listarPasajero();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }

    public void eliminarPasajero() {
        int fila = vistaPasajero.tblPasajero.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar");
            return;
        }

        String documento = vistaPasajero.txtDocumento.getText();
        int confirmacion = JOptionPane.showConfirmDialog(null, 
            "¿Está seguro de eliminar este registro?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (daoPasajero.eliminar(documento)) {
                JOptionPane.showMessageDialog(null, "Pasajero eliminado");
                listarPasajero();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }

    private Pasajero obtenerDatosFormulario() {
        Pasajero p = new Pasajero();
        p.setTipo_documento(vistaPasajero.cbxTipo.getSelectedItem().toString());
        p.setDocumento(vistaPasajero.txtDocumento.getText());
        p.setNombre(vistaPasajero.txtNombre.getText());
        p.setApellido(vistaPasajero.txtApellido.getText());
        
        return p;
    }

    public void listarPasajero() {
        ArrayList<Pasajero> Lista = daoPasajero.Listar();
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Documento");
        modelo.addColumn("Tipo_documento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha_nacimiento");
        modelo.addColumn("Correo");
        
        for (Pasajero p : Lista) {
            Object datos[] = {
                p.getDocumento(),
                p.getTipo_documento(),
                p.getNombre(),
                p.getApellido(),
                p.getNacionalidad(),
                p.getTelefono(),
                p.getFecha_nacimiento(),
                p.getCorreo()
            };
            modelo.addRow(datos);
        }
        vistaPasajero.tblPasajero.setModel(modelo);
    }
    
}
