/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ProyectoDAO.UsuarioImplementationDAO;
import vista.VentanaActualizar;

/**
 *
 * @author pablo
 */
public class ActualizarController {
    private UsuarioImplementationDAO usuarioDao;
    private VentanaActualizar vista;
    
    public ActualizarController(UsuarioImplementationDAO usuarioDao, VentanaActualizar vista){
        this.usuarioDao = usuarioDao; 
        this.vista = vista; 
        rellenarCampos();
        
    }
    
    public void rellenarCampos(){
        vista.getNombreTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getNombre());
        vista.getApellidoTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getApellido());
        vista.getFechaNacimientoTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getFechaNacimiento());
        vista.getIdentificacionTextField().setText(usuarioDao.getPersona(usuarioDao.getTipoActualizar(), usuarioDao.getIdentificacionActualizar()).getIdentificacion());
        
    }
    
}
