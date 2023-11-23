/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.InfoPersona;
import vista.VentanaActualizar;
import vista.VentanaMostrar;
import vista.VentanaPrincipal;
import vista.VistaAgregarContacto;

/**
 *
 * @author USER CT
 */
public class UsuarioController {
    private UsuarioImplementationDAO directorio;
    private VentanaPrincipal ventana;
    private String identificacionActualizar = "";
    private String tipoActualizar = "";
    private String identificacionVer = "";
    private String tipoVer = "";

    public UsuarioController(UsuarioImplementationDAO implemetacionDao, VentanaPrincipal ventana) {
        
            //this.directorio = new UsuarioImplementationDAO();
        this.directorio = implemetacionDao;
        System.out.println(directorio);
        
        this.ventana = ventana;
        ventana.addBtnCrearListener(new btnCrearListener());
        ventana.addBtnEliminarListener(new btnEliminarListener());
        ventana.addBtnActualizarListener(new btnActualizarListener());
        //ventana.addBtnVerListener(new btnVerListener());
        ventana.addJradioEstudiantesListener(new radioEstudiantes());
        ventana.addJradioProfesoresListener(new radioProfesores());
        ventana.addJradioEmpleadosListener(new radioEmpleados());
        ventana.setVisible(true);
        agregarRegistrosLista();
        
    }
    
    class btnCrearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.dispose();
            AgregarController vista = new AgregarController(directorio, new VistaAgregarContacto());
        }
        
    }
    class btnEliminarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        if (ventana.getjTableContactos().getRowCount() > 0) {
            int filaSeleccionada = ventana.getjTableContactos().getSelectedRow();

            if (filaSeleccionada != -1) {
                String numeroIdentificacion = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 4);
                String tipoContacto = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 3);

                System.out.println(tipoContacto);
                System.out.println(numeroIdentificacion);

                directorio.eliminarPersona(numeroIdentificacion, tipoContacto);
                agregarRegistrosLista();
                ventana.getjRadioEstudiantes().setSelected(false);
                ventana.getjRadioEmpleados().setSelected(false);
                ventana.getjRadioProfesores().setSelected(false);
            } else {
                // No hay fila seleccionada
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // La tabla no tiene filas
            JOptionPane.showMessageDialog(null, "La tabla está vacía", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
        
    }
    class btnActualizarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int filaSeleccionada = ventana.getjTableContactos().getSelectedRow();

            if (filaSeleccionada != -1) {
                String identificacion = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 4);
                String tipo = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 3);

                directorio.setIdentificacionActualizar(identificacion);
                directorio.setTipoActualizar(tipo);

                VentanaActualizar vista = new VentanaActualizar();
                ActualizarController controller = new ActualizarController(directorio, vista);
                ventana.dispose();
            } else {
                // No hay fila seleccionada
                JOptionPane.showMessageDialog(null, "No hay fila seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    
    class radioEstudiantes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.getjRadioEmpleados().setSelected(false);
            ventana.getjRadioProfesores().setSelected(false);
            agregarRegistrosEstudiantes();
            System.out.println("ver");
            
            
        }
        
    }
    
    class radioEmpleados implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.getjRadioEstudiantes().setSelected(false);
            ventana.getjRadioProfesores().setSelected(false);
            agregarRegistrosEmpleados();
            System.out.println("ver");
            
            
        }
        
    }
    
    class radioProfesores implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.getjRadioEstudiantes().setSelected(false);
            ventana.getjRadioEmpleados().setSelected(false);
            agregarRegistrosProfesores();
            System.out.println("ver");
            
            
        }
        
    }
    
    
    
    void agregarFilaTabla(InfoPersona contacto) {
           
        Object[] fila = {
                contacto.getNombre(),
                contacto.getApellido(),
                contacto.getTelefonos().get(0),
                contacto.getTipoContacto(),
                contacto.getIdentificacion()
        };
        ventana.getModeloTabla().addRow(fila);
    }
    
    
    void agregarRegistrosLista(){
        ventana.getModeloTabla().setRowCount(0);
        for(InfoPersona persona : directorio.getDirectorio().getEmpleados()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
        for(InfoPersona persona : directorio.getDirectorio().getEstudiantes()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
        for(InfoPersona persona : directorio.getDirectorio().getProfesores()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
    }
    
    void agregarRegistrosEstudiantes(){
        ventana.getModeloTabla().setRowCount(0);
       
        for(InfoPersona persona : directorio.getDirectorio().getEstudiantes()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
        
    }
    
    void agregarRegistrosProfesores(){
        ventana.getModeloTabla().setRowCount(0);
        
        for(InfoPersona persona : directorio.getDirectorio().getProfesores()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
    }
    
    void agregarRegistrosEmpleados(){
        ventana.getModeloTabla().setRowCount(0);
        for(InfoPersona persona : directorio.getDirectorio().getEmpleados()){
            if(persona != null){
                agregarFilaTabla(persona);
            }
        }
        
    }

    public UsuarioImplementationDAO getDirectorio() {
        return directorio;
    }

    public void setDirectorio(UsuarioImplementationDAO directorio) {
        this.directorio = directorio;
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public void setVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    public String getIdentificacionActualizar() {
        return identificacionActualizar;
    }

    public void setIdentificacionActualizar(String identificacionActualizar) {
        this.identificacionActualizar = identificacionActualizar;
    }

    public String getTipoActualizar() {
        return tipoActualizar;
    }

    public void setTipoActualizar(String tipoActualizar) {
        this.tipoActualizar = tipoActualizar;
    }

    public String getIdentificacionVer() {
        return identificacionVer;
    }

    public void setIdentificacionVer(String identificacionVer) {
        this.identificacionVer = identificacionVer;
    }

    public String getTipoVer() {
        return tipoVer;
    }

    public void setTipoVer(String tipoVer) {
        this.tipoVer = tipoVer;
    }
    
    
    
    
    
    
    
    
    
    
        
}
