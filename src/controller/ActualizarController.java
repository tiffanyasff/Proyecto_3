/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.InfoPersona;
import vista.VentanaActualizar;
import vista.VentanaPrincipal;
import vista.VistaActNumeros;

/**
 *
 * @author pablo
 */
public class ActualizarController {
    private UsuarioImplementationDAO usuarioDao;
    private VentanaActualizar vista;
    private ArrayList<JTextField> campos;
    private ArrayList<String> direcciones, lugares, telefonos;
    private String tipoViejo;
    
    public ActualizarController(UsuarioImplementationDAO usuarioDao, VentanaActualizar vista){
        this.usuarioDao = usuarioDao; 
        this.vista = vista;
        campos = new ArrayList<>();
        campos.add(vista.getNombreTextField());
        campos.add(vista.getApellidoTextField());
        campos.add(vista.getFechaNacimientoTextField());
        campos.add(vista.getIdentificacionTextField());
        vista.addBtnActualizarListener(new btnActualizarListener());
        vista.addBtnDireccionListener(new btnAgregarDireccionesListener());
        vista.addBtnTelefonosListener(new btnAgregarTelefonoListener());
        vista.addBtnEliminarTelefonoListener(new btnEliminarTelefonoListener());
        direcciones = new ArrayList<>();
        lugares = new ArrayList<>();
        telefonos = new ArrayList<>();
        rellenarCampos();
        
    }
    
    public void rellenarCampos(){
        vista.getNombreTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getNombre());
        vista.getApellidoTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getApellido());
        vista.getFechaNacimientoTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getFechaNacimiento());
        vista.getIdentificacionTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getIdentificacion());
        
        //String[] opcionesLugarAsociado = {"empleado", "estudiante", "profesor"};
        //tipoContactoTextCombo = new JComboBox<>(opcionesLugarAsociado);
        
        if (usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getTipoContacto().equals("empleado")){
            vista.getTipoContactoTextField().setSelectedIndex(0);
        }else if(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getTipoContacto().equals("estudiante")){
            vista.getTipoContactoTextField().setSelectedIndex(1);
        }else{
            vista.getTipoContactoTextField().setSelectedIndex(2);
        }
        tipoViejo = vista.getTipoSeleccionado();
        
    }
    
    class btnActualizarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (verificarEspaciosLLenos()) {
                if(idExiste(vista.getIdentificacionTextField().getText()) == false){
                    usuarioDao.actualizarPersona(
                    vista.getNombreTextField().getText(),
                   vista.getApellidoTextField().getText(),
                      vista.getTipoSeleccionado(),
                     vista.getFechaNacimientoTextField().getText(),
                       vista.getIdentificacionTextField().getText(),
                     lugares,
                          telefonos,
                          direcciones,
                    usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()),
                          tipoViejo);
                    //System.out.println(usuarioDao.getDirectorio().getEmpleados());
                    System.out.println(tipoViejo);
                    System.out.println(vista.getTipoSeleccionado());
                    vista.getVentanaAgregar().dispose();
                    UsuarioController principal = new UsuarioController(usuarioDao, new VentanaPrincipal());
                }else{
                    JOptionPane.showMessageDialog(null, "El identificador ya existe, ingresa uno distinto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Mostrar mensaje de advertencia si no todos los espacios están llenos
                JOptionPane.showMessageDialog(null, "Rellena todos los espacios con asterisco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
    
    class btnAgregarTelefonoListener implements ActionListener{

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
    
    class btnAgregarDireccionesListener implements ActionListener{

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
    
    
    class btnEliminarTelefonoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // Crear la nueva ventana
            VistaActNumeros subVista = new VistaActNumeros();

            // Desactivar la ventana principal
            vista.getPanel().setEnabled(false);

            // Mostrar la nueva ventana
            subVista.setVisible(true);

            // Crear el controlador para la nueva ventana
            ActualizarSubVentanaController controlador = new ActualizarSubVentanaController(usuarioDao, subVista);

            // Agregar un WindowListener para volver a activar la ventana principal cuando la nueva ventana se cierre
            subVista.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // Activar la ventana principal cuando la nueva ventana se cierre
                    vista.getPanel().setEnabled(true);
                }
            });
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

        String idIngresado = vista.getIdentificacionTextField().getText();
        String idActual = usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getIdentificacion();

        if (!idIngresado.equals(idActual)) {
            for (InfoPersona empleado : empleados) {
                if (empleado.getIdentificacion().equals(idIngresado)) {
                    return true; // El ID existe en la lista de empleados
                }
            }

            for (InfoPersona profesor : profesores) {
                if (profesor.getIdentificacion().equals(idIngresado)) {
                    return true; // El ID existe en la lista de profesores
                }
            }

            for (InfoPersona estudiante : estudiantes) {
                if (estudiante.getIdentificacion().equals(idIngresado)) {
                    return true; // El ID existe en la lista de estudiantes
                }
            }
        }

        // Si llegamos a este punto, el ID no existe o no necesitamos verificarlo
        return false;
    }
    
}
