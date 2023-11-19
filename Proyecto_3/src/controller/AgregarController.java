/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import vista.VentanaPrincipal;
import vista.VistaAgregarContacto;

/**
 *
 * @author pablo
 */
public class AgregarController {
    private UsuarioImplementationDAO usuarioDao;
    private VistaAgregarContacto vista;
    private ArrayList<String> direcciones, lugares, telefonos;
    private ArrayList<JTextField> campos;

    public AgregarController(UsuarioImplementationDAO usuarioDao, VistaAgregarContacto vista) {
        
        this.usuarioDao = usuarioDao;
        
        this.vista = vista;
        direcciones = new ArrayList<>();
        lugares = new ArrayList<>();
        telefonos = new ArrayList<>();
        campos = new ArrayList<>();
        campos.add(vista.getNombreTextField());
        campos.add(vista.getApellidoTextField());
        campos.add(vista.getFechaNacimientoTextField());
        campos.add(vista.getIdentificacionTextField());
        
        vista.addBtnCrearListener(new btnCrearListener());
        vista.addBtnDireccionListener(new btnDireccionesListener());
        vista.addBtnTelefonosListener(new btnTelefonosListener());
    }
    
    class btnCrearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarEspaciosLLenos()) {
                usuarioDao.crearPersona(vista.getNombreTextField().getText(), vista.getApellidoTextField().getText(), vista.getTipoSeleccionado(), vista.getFechaNacimientoTextField().getText(), vista.getIdentificacionTextField().getText(), lugares, direcciones, telefonos);
                System.out.println(usuarioDao.getDirectorio().getEmpleados());
                vista.getNombreTextField().setText("");
                vista.getTelefonosTextField().setText("");
                vista.getApellidoTextField().setText("");
                vista.getFechaNacimientoTextField().setText("");
                vista.getIdentificacionTextField().setText("");
                vista.getLugarAsociado().setText("");
                vista.getDireccionTextField().setText("");
                vista.getVentanaAgregar().dispose();
                //new UsuarioController(usuarioDao,new VentanaPrincipal());
                UsuarioController principal = new UsuarioController (usuarioDao,new VentanaPrincipal());
            }
            
        }
        
    }
    
    class btnTelefonosListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!vista.getTelefonosTextField().getText().trim().isEmpty() && !vista.getLugarAsociado().getText().trim().isEmpty() ) {
                telefonos.add(vista.getTelefonosTextField().getText());
                lugares.add(vista.getLugarAsociado().getText());
                vista.getTelefonosTextField().setText("");
                vista.getLugarAsociado().setText("");
                System.out.println(telefonos);
                System.out.println(lugares);
            }else{
                System.out.println("nonas");
            }
            
        }
        
    }
    
    
    class btnDireccionesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (vista.getDireccionTextField().getText() != "") {
                direcciones.add(vista.getDireccionTextField().getText());
                vista.getDireccionTextField().setText("");
                System.out.println(direcciones);
                System.out.println(vista.getTipoSeleccionado());
            }
        }
        
    }
    
    public boolean verificarEspaciosLLenos() {
        boolean valido = true;
        for (JTextField campo : campos) {
            if (campo.getText().equals("")) {
                valido = false;
                break; // Terminar el bucle inmediatamente si se encuentra un campo vacío
            }
        }
        return valido;
    }
    
}
