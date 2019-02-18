/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author estudiantes
 */
public class Menu extends JFrame{
    JLabel subt = new JLabel("¿Que desea realizar?");
    JButton res = new JButton("Reserva");
    JButton checkin = new JButton("Check-In");
    JButton checkout = new JButton("Check-out");
    JButton pedirProd = new JButton("Solicitar producto o servicio");

    public Menu(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        c.add(subt);
        subt.setFont(new Font("dialog", 1, 24));
        subt.setBounds(20, 15, 300, 30);
        c.add(res);
        res.setBounds(100,80,100,25);
        res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resActionPerformed(evt);
            }
        });
        c.add(checkin);
        checkin.setBounds(100,120,100,25);
        c.add(checkout);
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });
        checkout.setBounds(100,160,100,25);
        c.add(pedirProd);
        pedirProd.setBounds(55,200,200,25); 
        setVisible(true);
        setSize(370,350);
                
    }
    public void checkinActionPerformed(java.awt.event.ActionEvent evt) { 
        Pregunta p = new Pregunta();
        setVisible(false);       
    }
    public void resActionPerformed(java.awt.event.ActionEvent evt) { 
        Reserva r = new Reserva();
        setVisible(false);       
    }
    
    
    
}
