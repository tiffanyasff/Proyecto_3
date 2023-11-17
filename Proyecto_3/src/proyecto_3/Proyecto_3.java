/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_3;

import ProyectoDAO.UsuarioImplementationDAO;
import controller.AgregarController;
import vista.VistaAgregarContacto;

/**
 *
 * @author USER CT
 */
public class Proyecto_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaAgregarContacto agregar = new VistaAgregarContacto();
        AgregarController agg = new AgregarController(new UsuarioImplementationDAO(), agregar);
    }
    
}
