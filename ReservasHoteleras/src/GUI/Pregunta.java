/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author estudiantes
 */
public class Pregunta extends JFrame{
    JLabel preg = new JLabel("¿Realizo la reserva?");
    JButton btnSi = new JButton("SI");
    JButton btnNo = new JButton("NO");
    JButton btnVol = new JButton("VOLVER");

    public Pregunta() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Pregunta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.setBackground(Color.DARK_GRAY);
        c.add(preg);
        c.add(btnSi);
        c.add(btnNo);
        c.add(btnVol);
        preg.setBounds(80, 15, 200, 35);
        btnSi.setBounds(80, 50, 90, 25);
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        btnNo.setBounds(80, 90, 90, 25);
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        btnVol.setBounds(80, 130, 100, 25);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });     
        
        setVisible(true);
        setSize(300,300);
    }
    public void btnSiActionPerformed(java.awt.event.ActionEvent evt) { 
        RegistroConReserva rcr = new RegistroConReserva();
        setVisible(false);       
    }
    public void btnNoActionPerformed(java.awt.event.ActionEvent evt) { 
        RegistroSinReserva rsr = new RegistroSinReserva();
        setVisible(false);       
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    }
    
    
    
    
    
    
}
