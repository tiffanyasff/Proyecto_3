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
    private ArrayList<String> direcciones;
    private ArrayList<JTextField> campos;

    public AgregarController(UsuarioImplementationDAO usarioDao, VistaAgregarContacto vista) {
        this.usarioDao = usarioDao;
        this.vista = vista;
        direcciones = new ArrayList<>();
        campos = new ArrayList<>();
        campos.add(vista.getNombreTextField());
        campos.add(vista.getApellidoTextField());
        campos.add(vista.getLugarAsociado());
        campos.add(vista.getFechaNacimientoTextField());
        campos.add(vista.getIdentificacionTextField());
        
        vista.addBtnCrearListener(new btnCrearListener());
        vista.addBtnDireccionListener(new btnDireccionesListener());
    }
    
    class btnCrearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //if (verificarEspaciosLLenos()) {
            //    usarioDao.crearPersona(vista.getNombreTextField(), vista.getApellidoTextField(), vista.getApellidoTextField(), vista.getFechaNacimientoTextField(), vista.getIdentificacionTextField(), vista.getLugarAsociadoSeleccionado(), direcciones);
            //}
            
        }
        
    }
    
    
    class btnDireccionesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (vista.getDireccionTextField().getText() != "") {
                direcciones.add(vista.getDireccionTextField().getText());
                System.out.println(direcciones);
                System.out.println(vista.getLugarAsociadoSeleccionado());
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
