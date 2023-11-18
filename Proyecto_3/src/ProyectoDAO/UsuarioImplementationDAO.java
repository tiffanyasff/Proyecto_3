/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDAO;

import java.util.ArrayList;
import java.util.Iterator;
import model.Directorio;
import model.InfoPersona;

/**
 *
 * @author USER CT
 */
public class UsuarioImplementationDAO implements InterfaceInfoPersona{
    
    private Directorio directorio = new Directorio(); 

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }

    @Override
    public void crearPersona(String nombre, String apellido, String tipo, String fecha, String id, ArrayList<String> lugar, ArrayList<String> direcciones, ArrayList<String> telefonos) {
        InfoPersona persona = new InfoPersona(nombre, apellido, tipo, fecha, id, lugar, direcciones, telefonos);
        
        if (persona.getTipoContacto() == "empleado") {
            directorio.getEmpleados().add(persona);
            System.out.println("contacto añadido");
        }else if(persona.getTipoContacto() == "estudiante"){
            directorio.getEstudiantes().add(persona);
            System.out.println("contacto añadido");
        }else if(persona.getTipoContacto() == "profesor"){
            directorio.getProfesores().add(persona);
            System.out.println("contacto añadido");
        }
        
    }

    @Override
    public void eliminarPersona(String id, String tipo) {
        if (tipo == "empleado") {
            for (Iterator<InfoPersona> iterator = directorio.getEmpleados().iterator(); iterator.hasNext();) {
                InfoPersona persona = iterator.next();
                if (persona.getIdentificacion() == id) {
                    iterator.remove(); // Elimina el objeto de la lista
                }
            }
        }else if(tipo == "estudiante"){
            for (Iterator<InfoPersona> iterator = directorio.getEstudiantes().iterator(); iterator.hasNext();) {
                InfoPersona persona = iterator.next();
                if (persona.getIdentificacion() == id) {
                    iterator.remove(); // Elimina el objeto de la lista
                }
            } 
        }else if(tipo == "profesor"){
            for (Iterator<InfoPersona> iterator = directorio.getProfesores().iterator(); iterator.hasNext();) {
                InfoPersona persona = iterator.next();
                if (persona.getIdentificacion() == id) {
                    iterator.remove(); // Elimina el objeto de la lista
                }
            }
        }
    }

    @Override
    public void actualizarPersona(String nombre, String apellido, String tipo, String fecha, String id, ArrayList<String> lugar, ArrayList<String> direcciones, InfoPersona persona) {
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTipoContacto(tipo);
        persona.setFechaNacimiento(fecha);
        persona.setIdentificacion(id);
        persona.setLugarAsociado(lugar);
        persona.setDirecciones(direcciones);
    }

    

    @Override
    public ArrayList<InfoPersona> getPersonas(String tipo) {
        if (tipo == "empleado") {
            return directorio.getEmpleados();
        }else if(tipo == "estudiante"){
            return directorio.getEstudiantes();
        }else if(tipo == "profesor"){
            return directorio.getProfesores();
        }else{
            return null;
        }
    }

    @Override
    public InfoPersona getPersona(String tipo, String id) {
        if ("empleado".equals(tipo)) {
            for (InfoPersona persona : directorio.getEmpleados()) {
                if (persona.getIdentificacion().equals(id)) {
                    return persona;
                }
            }
        } else if ("estudiante".equals(tipo)) {
            for (InfoPersona persona : directorio.getEstudiantes()) {
                if (persona.getIdentificacion().equals(id)) {
                    return persona;
                }
            }
        } else if ("profesor".equals(tipo)) {
            for (InfoPersona persona : directorio.getProfesores()) {
                if (persona.getIdentificacion().equals(id)) {
                    return persona;
                }
            }
        }
        return null; // Se llega aquí si no se encontró la persona en ninguna de las listas
    }
    
            
    
}
