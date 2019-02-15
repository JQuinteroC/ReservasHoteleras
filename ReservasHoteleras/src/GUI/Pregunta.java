/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

    public Pregunta() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Pregunta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.add(preg);
        c.add(btnSi);
        c.add(btnNo);
        preg.setBounds(80, 15, 200, 35);
        btnSi.setBounds(80, 50, 90, 25);
        btnNo.setBounds(80, 90, 90, 25);
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        setVisible(true);
        setSize(300,300);
    }
    public void btnNoActionPerformed(java.awt.event.ActionEvent evt) { 
        RegistroSinReserva r = new RegistroSinReserva();
        setVisible(false);       
    }
    
    
    
    
    
    
}
