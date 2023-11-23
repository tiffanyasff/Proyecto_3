/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.InfoPersona;
import vista.VistaActNumeros;

/**
 *
 * @author pablo
 */
public class ActualizarSubVentanaController {
    private UsuarioImplementationDAO usuarioDao;
    private VistaActNumeros vista;

    public ActualizarSubVentanaController(UsuarioImplementationDAO usuarioDao, VistaActNumeros vista) {
        this.usuarioDao = usuarioDao;
        this.vista = vista;
        vista.addBtnEliminarNumListener(new btnEliminarTelefonoListener());
        vista.addBtnEliminarDirListener(new btnEliminarDireccionListener());
        vista.addBtnVolverListener(new btnVolverListener());
        ponerDatos();
    }
    
    class btnEliminarTelefonoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> jComboNumeros = vista.getjComboNumeros();
            String telefonoSeleccionado = (String) jComboNumeros.getSelectedItem();

            if (jComboNumeros.getItemCount() > 1) {
                // Obtener referencias a las listas de teléfonos y lugares asociados
                ArrayList<String> telefonos = usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getTelefonos();
                ArrayList<String> lugaresAsociados = usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getLugarAsociado();

                // Llamar al método para eliminar el teléfono
                usuarioDao.eliminarTelefono(telefonoSeleccionado, telefonos, lugaresAsociados);

                // Actualizar la interfaz con los datos actualizados
                ponerDatos();
            } else {
                // Mostrar un mensaje al usuario indicando que no se puede eliminar el único teléfono
                JOptionPane.showMessageDialog(vista, "No se puede eliminar el único teléfono disponible", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    class btnEliminarDireccionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboDirecciones = vista.getjComboDirecciones();

            if (comboDirecciones.getItemCount() == 1) {
                // Mostrar mensaje al usuario indicando que no hay más direcciones para eliminar
                JOptionPane.showMessageDialog(vista, "El contacto necesita almenos una direccion, actualmente tiene solo una registrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String direccionSeleccionada = (String) comboDirecciones.getSelectedItem();
                if (direccionSeleccionada != null) {
                    usuarioDao.eliminarDireccion(direccionSeleccionada,
                            usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getDirecciones());
                    ponerDatos();
                } else {
                    // No se ha seleccionado ninguna dirección, puedes manejarlo según tus necesidades
                    JOptionPane.showMessageDialog(vista, "Por favor, selecciona una dirección", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
    }
    
    class btnVolverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
        }
        
    }
    
    
    public void ponerDatos() {
        // Obtener la persona actualizada
        InfoPersona personaActualizada = usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar());

        // Limpiar el JComboBox antes de agregar nuevos elementos
        vista.getjComboNumeros().removeAllItems();
        vista.getjComboDirecciones().removeAllItems();

        // Recorrer los teléfonos y agregarlos al JComboBox
        for (String telefono : personaActualizada.getTelefonos()) {
            vista.getjComboNumeros().addItem(telefono);
        }


        for (String direcciones : personaActualizada.getDirecciones()) {
            vista.getjComboDirecciones().addItem(direcciones);
        }
}
    
}
