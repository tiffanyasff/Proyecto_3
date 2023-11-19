/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InfoPersona;
import vista.VentanaActualizar;
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

    public UsuarioController(UsuarioImplementationDAO implemetacionDao, VentanaPrincipal ventana) {
        
            //this.directorio = new UsuarioImplementationDAO();
        this.directorio = implemetacionDao;
        System.out.println(directorio);
        
        this.ventana = ventana;
        ventana.addBtnCrearListener(new btnCrearListener());
        ventana.addBtnEliminarListener(new btnEliminarListener());
        ventana.addBtnActualizarListener(new btnActualizarListener());
        ventana.addBtnVerListener(new btnVerListener());
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
            int filaSeleccionada = ventana.getjTableContactos().getSelectedRow();
            String numeroIdentificacion = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 4);
            String tipoContacto = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 3);
            System.out.println(tipoContacto);
            System.out.println(numeroIdentificacion);
            directorio.eliminarPersona(numeroIdentificacion, tipoContacto);
            agregarRegistrosLista();
            
            
        }
        
    }
    class btnActualizarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int filaSeleccionada = ventana.getjTableContactos().getSelectedRow();
            String identificacion = (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 4);
            String tipo= (String) ventana.getModeloTabla().getValueAt(filaSeleccionada, 3);
            directorio.setIdentificacionActualizar(identificacion);
            directorio.setTipoActualizar(tipo);
            VentanaActualizar vista = new VentanaActualizar();
            ActualizarController controller = new ActualizarController(directorio, vista);
            ventana.dispose();
            
            
            
        }
        
    }
    class btnVerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
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
    
    
    
    
    
    
    
    
        
}
