/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Directorio {
    private ArrayList<InfoPersona> empleados;
    private ArrayList<InfoPersona> estudiantes;
    private ArrayList<InfoPersona> profesores;

    public Directorio() {
        this.empleados = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }

    public ArrayList<InfoPersona> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<InfoPersona> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<InfoPersona> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<InfoPersona> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<InfoPersona> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<InfoPersona> profesores) {
        this.profesores = profesores;
    }
    
    
    
    
}
