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
import vista.VistaAgregarContacto;

/**
 *
 * @author pablo
 */
public class AgregarController {
    private UsuarioImplementationDAO usarioDao;
    private VistaAgregarContacto vista;
    private ArrayList<String> direcciones, lugares, telefonos;
    private ArrayList<JTextField> campos;

    public AgregarController(UsuarioImplementationDAO usarioDao, VistaAgregarContacto vista) {
        this.usarioDao = usarioDao;
        this.vista = vista;
        direcciones = new ArrayList<>();
        lugares = new ArrayList<>();
        telefonos = new ArrayList<>();
        campos = new ArrayList<>();
        campos.add(vista.getNombreTextField());
        campos.add(vista.getApellidoTextField());
        campos.add(vista.getLugarAsociado());
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
                usarioDao.crearPersona(vista.getNombreTextField().getText(), vista.getApellidoTextField().getText(), vista.getTipoSeleccionado(), vista.getFechaNacimientoTextField().getText(), vista.getIdentificacionTextField().getText(), lugares, direcciones, telefonos);
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
                System.out.println(direcciones);
                System.out.println(vista.getTipoSeleccionado());
            }
        }
        
    }
    
    public boolean verificarEspaciosLLenos(){
        boolean valido = true;
        for (JTextField campo : campos) {
            if (campo.getText() == "" || campo.getText() == null  ) {
                valido = false;
                return valido;
            }else{
                return valido;
            }
        }
        return valido;
    }
    
}
