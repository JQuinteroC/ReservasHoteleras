/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author estudiantes
 */
public class RegistroSinReserva extends JFrame{
    JLabel etqNId = new JLabel("Digite el numero de identificacion");
    JLabel etqTId = new JLabel("Digite el tipo de documento");
    JLabel etqNombre = new JLabel("Digite sus nombres");
    JLabel etqApellido = new JLabel("Digite sus apellidos");
    JLabel etqPais = new JLabel("Digite el pais donde reside");
    JLabel etqCiudad = new JLabel("Digite la ciudad donde reside");
    JLabel etqBarrio = new JLabel("Digite el barrio donde reside");
    JLabel etqDir = new JLabel("Digite la direccion donde reside");
    JLabel etqTlfijo = new JLabel("Digite el numero del telefono fijo");
    JLabel etqTlcel = new JLabel("Digite el numero del telefono celular");
    JTextField textNId = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textAoellido = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textCiudad = new JTextField();
    JTextField textBarrio = new JTextField();
    JTextField textDir = new JTextField();
    JTextField textTlfijo = new JTextField();
    JTextField textTlcel = new JTextField();
    
    String[] TipId = {"Cedula de ciudadania", "Tarjeta de identidad", "Cedula de extranjeria"};
    JComboBox<String> cbTId = new JComboBox<String>();
    
    public RegistroSinReserva() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro sin reserva");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.add(etqNId);
        c.add(etqTId);
        c.add(etqNombre);
        c.add(etqApellido);
        c.add(etqPais);
        c.add(etqCiudad);
        c.add(etqBarrio);
        c.add(etqDir);
        c.add(etqTlfijo);
        c.add(etqTlcel);
        c.add(textNId);
        c.add(cbTId);
        c.add(textNombre);
        c.add(textAoellido);
        c.add(textPais);
        c.add(textCiudad);
        c.add(textBarrio);
        c.add(textDir);
        c.add(textTlfijo);
        c.add(textTlcel);
        
        etqNId.setBounds(50, 100, 200, 25);
        etqTId.setBounds(50, 130, 200, 25);
        etqNombre.setBounds(50, 160, 200, 25);
        etqApellido.setBounds(50, 190, 200, 25);
        etqPais.setBounds(50, 220, 200, 25);
        etqCiudad.setBounds(50, 250, 200, 25);
        etqBarrio.setBounds(50, 280, 200, 25);
        etqDir.setBounds(50, 310, 200, 25);
        etqTlfijo.setBounds(50, 340, 200, 25);
        etqTlcel.setBounds(50, 370, 250, 25);
        textNId.setBounds(300,100,150,25);
        cbTId.setBounds(300, 130, 200, 25);
        cbTId.addItem("Cedula de ciudadania");
        cbTId.addItem("Tarjeta de identidad");
        cbTId.addItem("Pasaporte");
        cbTId.setSelectedIndex(-1);
        cbTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTIdActionPerformed(evt);
            }
        });
        textNombre.setBounds(300,160,150,25);
        textAoellido.setBounds(300,190,150,25);
        textPais.setBounds(300,220,150,25);
        textCiudad.setBounds(300,250,150,25);
        textBarrio.setBounds(300,280,150,25);
        textDir.setBounds(300,310,150,25);
        textTlfijo.setBounds(300,340,150,25);
        textTlcel.setBounds(300,370,150,25);
        
        setVisible(true);
        setSize(600,600);
        
        
    }
    public void cbTIdActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    
    
}
