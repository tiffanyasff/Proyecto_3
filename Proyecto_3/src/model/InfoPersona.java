/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList; 

/**
 *
 * @author USER CT
 */
public class InfoPersona {
    private String nombre;
    private String apellido;
    private String tipoContacto;
    private String fechaNacimiento;
    private String identificacion;
    private String lugarAsociado;
    private ArrayList<String> direcciones;

    public InfoPersona(String nombre, String apellido, String tipoContacto, String fechaNacimiento, String identificacion, String lugarAsociado, ArrayList<String> direcciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoContacto = tipoContacto;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.lugarAsociado = lugarAsociado;
        this.direcciones = direcciones;
    }
    
    public InfoPersona() {
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.tipoContacto = "tipoContacto";
        this.fechaNacimiento = "fecha";
        this.identificacion = "id";
        this.lugarAsociado = "lugar";
        this.direcciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getLugarAsociado() {
        return lugarAsociado;
    }

    public void setLugarAsociado(String lugarAsociado) {
        this.lugarAsociado = lugarAsociado;
    }

    public ArrayList<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<String> direcciones) {
        this.direcciones = direcciones;
    }
    
    
    
    
    
    
}
