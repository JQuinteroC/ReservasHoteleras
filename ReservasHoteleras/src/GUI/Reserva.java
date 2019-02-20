/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGIC.FormatoCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class Reserva extends JFrame{
    JLabel lblFecha = new JLabel("Fecha de inicio");
    JLabel lblNoches = new JLabel("Noches ha hospedarse");
    JLabel lblHabDis = new JLabel("Habitaciones disponibles");
    JTextField textCntNoc = new JTextField();   
    JButton btnVeri = new JButton("VERIFICAR");
    JButton btnRes = new JButton("RESERVAR");
    JButton btnVol = new JButton("VOLVER");    
    JDateChooser jd = new JDateChooser();
    JTextField txtObtDate = new JTextField();
    FormatoCalendar f = new FormatoCalendar();
    JTable tblHab = new  JTable();
    JScrollPane scroll = new JScrollPane(tblHab);
    

    public Reserva(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c.add(lblFecha);
        c.add(lblNoches);
        c.add(lblHabDis);
        c.add(textCntNoc);
        c.add(btnVeri);
        c.add(btnRes);
        c.add(btnVol);
        c.add(jd);
        c.add(txtObtDate);
        c.add(scroll);
        
        lblFecha.setFont(new Font("dialog", 1, 24));
        lblNoches.setFont(new Font("dialog", 1, 24));
        lblHabDis.setFont(new Font("dialog", 1, 28));
        lblFecha.setBounds(45, 75, 250, 25);
        lblNoches.setBounds(350, 75, 350, 25);
        lblHabDis.setBounds(225, 250, 350, 25);
        //Link de una manera de poner una Tabla de la db a un JScrollPane
        tblHab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String [] {
                "*","Nombre", "Número", "Tipo", "Costo noche", "Capacidad"
            }
        ));
        scroll.setBounds(180, 310, 500, 250);
        textCntNoc.setBounds(350, 105, 100, 25);
        btnVeri.setBounds(190, 180, 150, 35);
        btnVeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeriActionPerformed(evt);
            }
        });
        btnRes.setBounds(320, 805, 150, 35);
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });
        btnVol.setBounds(520, 805, 150, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        jd.setBounds(45, 105, 150, 35);
        txtObtDate.setBounds(10, 150, 150, 35);
        
        setVisible(true);
        setSize(800,900);
    }
    
    public void btnVeriActionPerformed(java.awt.event.ActionEvent evt) {
        txtObtDate.setText(f.getFecha(jd));        
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    }
    public void btnResActionPerformed(java.awt.event.ActionEvent evt) {
        ReservaIngresar ri = new ReservaIngresar();
        
    }
    
    
    
    
    
    
}
