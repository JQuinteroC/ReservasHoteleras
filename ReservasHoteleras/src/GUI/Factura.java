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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author david
 */
public class Factura extends JFrame{
    JLabel etqNombHot = new JLabel("Hotel \n ******");
    JLabel etqFac = new JLabel("Factura");
    JTable tblDatos = new JTable();
    JTable tblServProd = new JTable();
    JScrollPane scDatos = new JScrollPane(tblDatos);
    JScrollPane scSerPro = new JScrollPane(tblServProd);
    JButton btnImp = new JButton("IMPRIMIR");
    JButton btnVol = new JButton("VOLVER");

    public Factura(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Factura");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c.setBackground(Color.DARK_GRAY);
        c.add(etqNombHot);
        c.add(etqFac);
        c.add(scDatos);
        c.add(scSerPro);
        c.add(btnImp);
        c.add(btnVol);
        
        etqNombHot.setBounds(50, 20, 200, 180);
        etqNombHot.setFont(new Font("dialog", 1, 20));
        etqNombHot.setForeground(Color.GREEN);
        etqFac.setBounds(420, 50, 100, 35);
        etqFac.setForeground(Color.WHITE);
        scDatos.setBounds(100, 150, 450, 200);
        scSerPro.setBounds(100, 400, 450, 200);
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
            },
            new String [] {
                "Nombre","Cedula", "Direccion", "Telefono", "Fecha ingreso"
            }
        ));
        tblServProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "Codigo","Cantidad", "Servicio", "Total"
            }
        ));
        btnImp.setBounds(200, 650, 100, 50);
        btnImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpActionPerformed(evt);
            }
        });
        btnVol.setBounds(400, 650, 100, 50);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        setVisible(true);
        setSize(600,800);
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        setVisible(false);       
    }
    public void btnImpActionPerformed(java.awt.event.ActionEvent evt) { 
        JOptionPane.showMessageDialog(this, "¡Exito!      Pago realizado, \n\n\n         ¡Vuelva Pronto!");
        setVisible(false);
    }
    
    
    
}
