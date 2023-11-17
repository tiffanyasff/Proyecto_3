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
    private JButton btnCrearContacto, btnAgregarDireccion;

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
        
        nombreLabel.setBounds(40, 80, 150, 90);
        apellidoLabel.setBounds(40, 160, 150, 90);
        tipoContactoLabel.setBounds(40, 240, 150, 90);
        fechaNacimientoLabel.setBounds(40, 325, 190, 90);
        identificacionLabel.setBounds(40, 400, 150, 90);
        lugarAsociadoLabel.setBounds(40, 480, 150, 90);
        direccionesLabel.setBounds(40, 560, 150, 90);
        
        nombreTextField.setBounds(220, 120, 100, 20);
        apellidoTextField.setBounds(220, 195, 100, 20);
        tipoContactoTextField.setBounds(220, 275, 100, 20);
        fechaNacimientoTextField.setBounds(220, 360, 100, 20);
        identificacionTextField.setBounds(220, 440, 100, 20);
        lugarAsociadoTextField.setBounds(220, 520, 100, 20);
        direccionTextField.setBounds(220, 590, 100, 20);
        
        panel.add(nombreLabel);
        panel.add(apellidoLabel);
        panel.add(tipoContactoLabel);
        panel.add(fechaNacimientoLabel);
        panel.add(identificacionLabel);
        panel.add(lugarAsociadoLabel);
        panel.add(direccionesLabel);
        
        
        panel.add(nombreTextField);
        panel.add(apellidoTextField);
        panel.add(tipoContactoTextField);
        panel.add(fechaNacimientoTextField);
        panel.add(identificacionTextField);
        panel.add(lugarAsociadoTextField);
        panel.add(direccionTextField);
        
        
        
        
        
        ventanaAgregar.add(panel);
        panel.setVisible(true);
        ventanaAgregar.setVisible(true);

    }
}

