/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
class NumeroReserva extends JFrame{
    JLabel etqNumRes = new JLabel("El numero de la reserva es: ");
    JTextField txtNumRes = new JTextField();
    JButton btnObt = new JButton("Terminar");

    public NumeroReserva(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Numero de la reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        c.setBackground(Color.DARK_GRAY);
        c.add(etqNumRes);
        c.add(txtNumRes);
        c.add(btnObt);
        
        etqNumRes.setBounds(50, 100, 150, 35);
        txtNumRes.setBounds(250, 100, 150, 35);
        btnObt.setBounds(150, 170, 150, 35);
        
        setVisible(true);
        setSize(500,400);
    }
    
    
    
}
