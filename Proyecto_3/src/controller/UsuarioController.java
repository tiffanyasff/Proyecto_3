/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.InfoPersona;
import vista.VentanaPrincipal;
import vista.VistaAgregarContacto;

/**
 *
 * @author USER CT
 */
public class UsuarioController {
    private UsuarioImplementationDAO directorio;
    private VentanaPrincipal ventana;

    public UsuarioController(UsuarioImplementationDAO implemetacionDao, VentanaPrincipal ventana) {
        
            //this.directorio = new UsuarioImplementationDAO();
        this.directorio = implemetacionDao;
        System.out.println(directorio);
        
        this.ventana = ventana;
        ventana.addBtnCrearListener(new btnCrearListener());
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
    
    void agregarFilaTabla(InfoPersona contacto) {
           
        Object[] fila = {
                contacto.getNombre(),
                contacto.getApellido(),
                contacto.getTelefonos().get(0),
                contacto.getTipoContacto()
        };
        ventana.getModeloTabla().addRow(fila);
    }
    
    
    void agregarRegistrosLista(){
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
    
    
    
    
    
    
    
    
        
}
