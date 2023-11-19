/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.InfoPersona;
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
                if (!telefonos.isEmpty() && !direcciones.isEmpty()) {
                    if(idExiste(vista.getIdentificacionTextField().getText()) == false){
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
                        UsuarioController principal = new UsuarioController(usuarioDao, new VentanaPrincipal());
                    }else{
                        JOptionPane.showMessageDialog(null, "El identificador ya existe, ingresa uno distinto.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Mostrar mensaje de error si telefonos o direcciones están vacíos
                    JOptionPane.showMessageDialog(null, "Llena los campos de telefonos, direcciones o lugares asociados.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Mostrar mensaje de advertencia si no todos los espacios están llenos
                JOptionPane.showMessageDialog(null, "Rellena todos los espacios con asterisco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
            
            if (!vista.getDireccionTextField().getText().equals("") || direcciones.isEmpty() == true) {
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
    
    public boolean idExiste(String id) {
        ArrayList<InfoPersona> empleados = usuarioDao.getDirectorio().getEmpleados();
        ArrayList<InfoPersona> profesores = usuarioDao.getDirectorio().getProfesores();
        ArrayList<InfoPersona> estudiantes = usuarioDao.getDirectorio().getEstudiantes();

        for (InfoPersona empleado : empleados) {
            if (empleado.getIdentificacion().equals(id)) {
                return true; // El ID existe en la lista de empleados
            }
        }

        for (InfoPersona profesor : profesores) {
            if (profesor.getIdentificacion().equals(id)) {
                return true; // El ID existe en la lista de profesores
            }
        }

        for (InfoPersona estudiante : estudiantes) {
            if (estudiante.getIdentificacion().equals(id)) {
                return true; // El ID existe en la lista de estudiantes
            }
        }

        return false; // El ID no existe en ninguna de las listas
    }
    
    

    
}
