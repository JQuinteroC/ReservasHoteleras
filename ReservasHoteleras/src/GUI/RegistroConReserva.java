/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGIC.FormatoCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class RegistroConReserva extends JFrame{
    FormatoCalendar f = new FormatoCalendar();
    JLabel etqDig = new JLabel("Digite el numero de reserva asignado");
    JLabel etqNId = new JLabel("El numero de identificacion");
    JLabel etqTId = new JLabel("El tipo de documento");
    JLabel etqFNac = new JLabel("La fecha de nacimiento");
    JTextField textNId = new JTextField();
    JTextField txtNumRes = new JTextField();
    JDateChooser jdc = new JDateChooser();
    JButton btnReg = new JButton("REGISTRAR");
    JButton btnVol = new JButton("VOLVER");
    JComboBox<String> cbTId = new JComboBox<String>();

    public RegistroConReserva(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro con reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(etqDig);
        c.add(etqNId);
        c.add(etqTId);
        c.add(etqFNac);
        c.add(txtNumRes);
        c.add(textNId);
        c.add(jdc);
        c.add(cbTId);
        c.add(btnReg);
        c.add(btnVol);
        
        etqDig.setBounds(50, 50, 300, 35);
        etqDig.setFont(new Font("dialog", 1, 16));
        etqDig.setForeground(Color.white);
        etqNId.setBounds(50, 100, 300, 25);
        etqNId.setForeground(Color.white);
        etqNId.setFont(new Font("Montserrat", 1, 14));
        etqTId.setBounds(50, 130, 200, 25);
        etqTId.setForeground(Color.white);
        etqTId.setFont(new Font("Montserrat", 1, 14));
        etqFNac.setBounds(50, 160, 250, 25);
        etqFNac.setForeground(Color.white);
        etqFNac.setFont(new Font("Montserrat", 1, 14));
        txtNumRes.setBounds(390, 50, 150, 35);
        txtNumRes.setBackground(new Color(0,51,51));
        txtNumRes.setForeground(Color.white);
        txtNumRes.setFont(new Font("Montserrat", 1, 14));
        textNId.setBounds(400,100,150,25);
        textNId.setBackground(new Color(0,51,51));
        cbTId.setBounds(400, 130, 170, 25);
        cbTId.setFont(new Font("Montserrat", 1, 14));        
        cbTId.addItem("Cedula de ciudadania");
        cbTId.addItem("Tarjeta de identidad");
        cbTId.addItem("Pasaporte");
        cbTId.setSelectedIndex(-1);
        jdc.setBounds(400,160,150,25);
        jdc.setBackground(new Color(0,51,51));
        jdc.setForeground(Color.white);
        jdc.setFont(new Font("Montserrat", 1, 14));
        
        btnReg.setBounds(50, 230, 150, 35);
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });
        btnVol.setBounds(250, 230, 150, 35);
        btnReg.setBounds(50, 250, 150, 35);
        btnVol.setBounds(250, 250, 150, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        setVisible(true);
        setSize(600,400);        
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Pregunta p = new Pregunta();
        setVisible(false);       
    }
    public void btnRegActionPerformed(java.awt.event.ActionEvent evt) {
        RegistroAcompañantes ra = new RegistroAcompañantes();
        setVisible(false);       
    }
    
}
