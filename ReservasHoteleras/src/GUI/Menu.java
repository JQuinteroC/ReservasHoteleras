/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author estudiantes
 */
public class Menu extends JFrame{
    JLabel subt = new JLabel("¿Que desea realizar?");
    ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/reserva.png"));
    Image imagen = icono.getImage();
    ImageIcon icnEsc = new ImageIcon(imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    ImageIcon icono2 = new ImageIcon(getClass().getResource("/Imagenes/checkin.png"));
    Image imagen2 = icono2.getImage();
    ImageIcon icnEsc2 = new ImageIcon(imagen2.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    ImageIcon icono3 = new ImageIcon(getClass().getResource("/Imagenes/cout.png"));
    Image imagen3 = icono3.getImage();
    ImageIcon icnEsc3 = new ImageIcon(imagen3.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    ImageIcon icono4 = new ImageIcon(getClass().getResource("/Imagenes/solic.png"));
    Image imagen4 = icono4.getImage();
    ImageIcon icnEsc4 = new ImageIcon(imagen4.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    JButton res = new JButton(icnEsc);
    JButton checkin = new JButton(icnEsc2);
    JButton checkout = new JButton(icnEsc3);
    JButton pedirProd = new JButton(icnEsc4);
    
    public Menu(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setBackground(Color.DARK_GRAY);
        
        
        
        c.add(subt);
        subt.setFont(new Font("dialog", 1, 24));
        subt.setForeground(Color.GREEN);
        subt.setBounds(90, 15, 300, 30);
        c.add(res);
        res.setBounds(80,80,100,100);
        res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resActionPerformed(evt);
            }
        });
        c.add(checkin);
        checkin.setBounds(230,80,100,100);
        c.add(checkout);
        checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinActionPerformed(evt);
            }
        });
        checkout.setBounds(80,230,100,100);
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        c.add(pedirProd);
        pedirProd.setBounds(230,230,100,100);
        pedirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedirProdActionPerformed(evt);
            }
        });
        setVisible(true);
        setSize(440,420);
                
    }
    public void checkinActionPerformed(java.awt.event.ActionEvent evt) { 
        Pregunta p = new Pregunta();
        setVisible(false);       
    }
    public void checkoutActionPerformed(java.awt.event.ActionEvent evt) { 
        Facturacion f = new Facturacion();
        setVisible(false);       
    }
    public void resActionPerformed(java.awt.event.ActionEvent evt) { 
        ReservaIngresoDatos rig = new ReservaIngresoDatos();
        setVisible(false);       
    }
    public void pedirProdActionPerformed(java.awt.event.ActionEvent evt) { 
        Solicitud s = new Solicitud();
        setVisible(false);       
    }
    
    
    
}
