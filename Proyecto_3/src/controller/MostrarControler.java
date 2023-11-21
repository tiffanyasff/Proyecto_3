/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InfoPersona;
import vista.VentanaMostrar;
import vista.VentanaPrincipal;

/**
 *
 * @author pablo
 */
public class MostrarControler {
    private VentanaMostrar ventana;
    private UsuarioImplementationDAO usuarioDao;
    private InfoPersona persona;

    public MostrarControler(VentanaMostrar ventana, UsuarioImplementationDAO usuarioDao) {
        this.ventana = ventana;
        this.usuarioDao = usuarioDao;
        this.ventana.setVisible(true);
        ventana.addBtnVolver(new btnVolverListener());
        ventana.addJComboNumero(new btnVolverListener());
        persona = usuarioDao.getPersona(usuarioDao.getTipoVer(), usuarioDao.getIdentificacionVer());
        cargarValores();
    }
    
    class btnVolverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //UsuarioController usuario = new UsuarioController(usuarioDao, new VentanaPrincipal());
            //ventana.dispose();
            
        }
    }
    
    
    class btnVolverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    public void cargarValores(){
        ventana.getLblNombre().setText(persona.getNombre());
        ventana.getLblApellido().setText(persona.getApellido());
        ventana.getLblTipoContacto().setText(persona.getTipoContacto());
        ventana.getLblNacimiendo().setText(persona.getFechaNacimiento());
        ventana.getLblidentificacion().setText(persona.getIdentificacion());
        ponerDatos();
    
    }
    
    public void ponerDatos() {
        // Obtener la persona actualizada
        
        // Limpiar el JComboBox antes de agregar nuevos elementos
        ventana.getjComboTelefonos().removeAllItems();
        ventana.getjComboDirecciones().removeAllItems();

        // Recorrer los teléfonos y agregarlos al JComboBox
        for (String telefono : persona.getTelefonos()) {
            ventana.getjComboTelefonos().addItem(telefono);
        }


        for (String direcciones : persona.getDirecciones()) {
            ventana.getjComboDirecciones().addItem(direcciones);
        }
}
    
    
    
}
