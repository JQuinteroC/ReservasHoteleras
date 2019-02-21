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
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class Solicitud extends JFrame{
    JLabel etqNom = new JLabel("Productos y servicios");
    JLabel etqNumHab = new JLabel("Numero de habitacion");
    JLabel etqNumId = new JLabel("Documento del huesped");
    JLabel etqCodProSer = new JLabel("Codigo de producto o servicio");
    JLabel etqNombProSer = new JLabel("Nombre de producto o servicio");
    JLabel etqCant = new JLabel("Cantidad");
    JLabel etqVal = new JLabel("Valor unidad");
    JTextField txtNumHab = new JTextField();
    JTextField txtNumId = new JTextField();
    JTextField txtCodProSer = new JTextField();
    JTextField txtNomProSer = new JTextField();
    JTextField txtCant = new JTextField();
    JTextField txtVal = new JTextField();
    JButton btnAgr = new JButton("AGREGAR");
    JButton btnSol = new JButton("SOLICITAR");
    JButton btnVol = new JButton("VOLVER");
    JTable tblSol = new JTable();
    JScrollPane jsc = new JScrollPane(tblSol);

    public Solicitud(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Solicitar Producto o Servicio");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(etqNom);
        c.add(etqNumHab);
        c.add(etqNumId);
        c.add(etqCodProSer);
        c.add(etqNombProSer);
        c.add(etqCant);
        c.add(etqVal);
        c.add(txtNumHab);
        c.add(txtNumId);
        c.add(txtCodProSer);
        c.add(txtNomProSer);
        c.add(txtCant);
        c.add(txtVal);
        c.add(btnAgr);
        c.add(btnSol);
        c.add(btnVol);
        c.add(jsc);
        
        etqNom.setBounds(100, 20, 350, 35);
        etqNom.setFont(new Font("dialog", 1, 26));
        etqNom.setForeground(Color.GREEN);
        etqNumHab.setBounds(30, 60, 200, 35);
        etqNumHab.setFont(new Font("dialog", 1, 16));
        etqNumHab.setForeground(Color.WHITE);
        etqNumId.setBounds(260, 60, 260, 35);
        etqNumId.setFont(new Font("dialog", 1, 16));
        etqNumId.setForeground(Color.WHITE);
        etqCodProSer.setBounds(60, 150, 260, 35);
        etqCodProSer.setFont(new Font("dialog", 1, 16));
        etqCodProSer.setForeground(Color.WHITE);
        etqNombProSer.setBounds(30, 250, 260, 35);
        etqNombProSer.setFont(new Font("dialog", 1, 16));
        etqNombProSer.setForeground(Color.WHITE);
        etqCant.setBounds(340, 250, 120, 35);
        etqCant.setFont(new Font("dialog", 1, 16));
        etqCant.setForeground(Color.WHITE);
        etqVal.setBounds(470, 250, 120, 35);
        etqVal.setFont(new Font("dialog", 1, 16));
        etqVal.setForeground(Color.WHITE);        
        txtNumHab.setBounds(30, 100, 90, 35);
        txtNumId.setBounds(260, 100, 150, 35);
        txtCodProSer.setBounds(60, 195, 150, 35);
        txtNomProSer.setBounds(30, 300, 270, 35);
        txtCant.setBounds(330, 300, 100, 35);
        txtVal.setBounds(450, 300, 120, 35);
        btnAgr.setBounds(590, 300, 90, 35);
        jsc.setBounds(30, 350, 570, 200);
        tblSol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "Nombre del servicio", "Cantidad", "Valor Unidad", "Valor total"
            }
        ));
        btnSol.setBounds(150, 600, 150, 50);
        btnSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolActionPerformed(evt);
            }
        });
        btnVol.setBounds(490, 600, 150, 50);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        
        
        setVisible(true);
        setSize(800,750);
    }
    public void btnSolActionPerformed(java.awt.event.ActionEvent evt) { 
        JOptionPane.showMessageDialog(this, "SOLICITUD HECHA \n EXITOSAMENTE");
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    }
    
    
    
    
}
