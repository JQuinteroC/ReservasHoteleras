/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author estudiantes
 */
public class Facturacion extends JFrame{
    JLabel etqTit = new JLabel("Facturacion");    
    JLabel etqDoc = new JLabel("Digite el numero de su documento");    
    JLabel etqNumHab = new JLabel("Digite el numero de su habitacion");    
    JLabel etqHabAso = new JLabel("Habitacion asociadas");   
    JTextField txtDoc = new JTextField(); 
    JTextField txtHab = new JTextField(); 
    JButton btnBus = new JButton("BUSCAR");
    JButton btnFac = new JButton("FACTURAR");
    JButton btnVol = new JButton("VOLVER");
    JTable tblHabAso = new JTable();
    JScrollPane scroll = new JScrollPane(tblHabAso);

    public Facturacion(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Facturacion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c.setBackground(Color.DARK_GRAY);
        c.add(etqTit);
        c.add(etqDoc);
        c.add(etqNumHab);
        c.add(etqHabAso);
        c.add(txtDoc);
        c.add(txtHab);
        c.add(btnBus);
        c.add(btnFac);
        c.add(btnVol);
        c.add(scroll);
        //c.setBackground(Color.DARK_GRAY);
        
        etqTit.setFont(new Font("dialog", 1, 24));
        etqTit.setBounds(140, 40, 200, 35);
        etqDoc.setBounds(100, 80, 200, 35);
        etqNumHab.setBounds(350, 80, 200, 35);
        etqHabAso.setBounds(120, 220, 200, 35);
        txtDoc.setBounds(100, 130, 150, 35);
        txtHab.setBounds(350, 130, 100, 35);
        btnBus.setBounds(150, 180, 100, 35);
        btnFac.setBounds(100, 600, 100, 35);
        btnVol.setBounds(300, 600, 100, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        scroll.setBounds(120, 260, 400, 180);
        tblHabAso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
            },
            new String [] {
                "*","Numero", "Fecha registro"
            }
        ));
        
        setVisible(true);
        setSize(600,800);
        
        
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    }
    
    
}
