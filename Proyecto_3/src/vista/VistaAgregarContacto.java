/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.InfoPersona;

public class VistaAgregarContacto extends JFrame {

    private JFrame ventanaAgregar;
    private JTextField nombreTextField, apellidoTextField, tipoContactoTextField, fechaNacimientoTextField, identificacionTextField, lugarAsociadoTextField, direccionTextField;
    private JTextArea direccionesTextArea;

    public VistaAgregarContacto() {
        ventanaAgregar = new JFrame("Agregar contacto");
        ventanaAgregar.setSize(600, 800);
        ventanaAgregar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Etiquetas
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel apellidoLabel = new JLabel("Apellido:");
        JLabel tipoContactoLabel = new JLabel("Tipo de Contacto:");
        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        JLabel identificacionLabel = new JLabel("Identificación:");
        JLabel lugarAsociadoLabel = new JLabel("Lugar Asociado:");
        JLabel direccionesLabel = new JLabel("Direcciones:");

        // Campos de texto
        nombreTextField = new JTextField();
        apellidoTextField = new JTextField();
        tipoContactoTextField = new JTextField();
        fechaNacimientoTextField = new JTextField();
        identificacionTextField = new JTextField();
        lugarAsociadoTextField = new JTextField();
        direccionTextField = new JTextField();
        direccionesTextArea = new JTextArea();
        
        nombreLabel.setBounds(250, 100, 60, 60);
        apellidoLabel.setBounds(250, 200, 60, 60);
        tipoContactoLabel.setBounds(250, 300, 60, 60);
        nombreLabel.setBounds(250, 400, 60, 60);
        nombreLabel.setBounds(250, 500, 60, 60);
        nombreLabel.setBounds(250, 600, 60, 60);
        nombreLabel.setBounds(250, 700, 60, 60);

    }
}

