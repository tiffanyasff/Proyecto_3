/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoDAO;

import java.util.ArrayList;
import model.InfoPersona;

/**
 *
 * @author pablo
 */
public interface InterfaceInfoPersona {
    public void crearPersona(String nombre, String apellido, String tipo, String fecha, String id, ArrayList<String> lugar, ArrayList<String> direcciones, ArrayList<String> telefonos);
    public void eliminarPersona(String id, String tipo);
    public void actualizarPersona(String nombre, String apellido, String tipo, String fecha, String id, ArrayList<String> lugar, ArrayList<String> direcciones, InfoPersona persona  );
    public ArrayList<InfoPersona> getPersonas(String tipo);
    public InfoPersona getPersona(String tipo, String id);
    
    
}
