/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGIC.FormatoCalendar;
import com.toedter.calendar.JDateChooser;
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
 * @author david
 */
public class HabitacionesDisponibles extends JFrame{
    FormatoCalendar f = new FormatoCalendar();
    JTable tblHabDis = new JTable();
    JScrollPane scHabDis = new JScrollPane(tblHabDis);
    JLabel etqDis = new JLabel("Las habitaciones disponibles son: ");
    JLabel etqFec = new JLabel("Fecha");
    JLabel etqNoc = new JLabel("Cantidad de noches");
    JButton btnVol = new JButton("VOLVER");
    JDateChooser jdc = new JDateChooser();
    JTextField txtNoc = new JTextField();
    JTextField txtObtDate = new JTextField();
    JButton btnCon = new JButton("CONSULTAR");

    public HabitacionesDisponibles(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Consultar Habitaciones disponibles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c.setBackground(Color.DARK_GRAY);
        c.add(etqDis);
        c.add(scHabDis);
        c.add(btnVol);
        c.add(etqFec);
        c.add(etqNoc);
        c.add(jdc);
        c.add(txtNoc);
        c.add(txtObtDate);
        c.add(btnCon);
        
        etqFec.setBounds(50, 20, 90, 35);
        etqFec.setFont(new Font("dialog", 1, 16));
        etqFec.setForeground(Color.WHITE);
        etqNoc.setBounds(350, 20, 220, 35);
        etqNoc.setFont(new Font("dialog", 1, 16));
        etqNoc.setForeground(Color.WHITE);
        txtNoc.setBounds(350, 60, 90, 25);
        jdc.setBounds(50, 60, 150, 25);
        btnCon.setBounds(150, 120, 150, 50);
        btnCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConActionPerformed(evt);
            }
        });
        etqDis.setBounds(50, 220, 350, 35);
        etqDis.setFont(new Font("dialoge", 1, 20));
        etqDis.setForeground(Color.WHITE);
        tblHabDis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "Número", "Tipo", "Capacidad", "Estado"
            }
        ));
        scHabDis.setBounds(50, 290, 400, 200);
        btnVol.setBounds(250, 540, 100, 50);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        
        setVisible(true);
        setSize(550,700);
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        setVisible(false);       
    }
    public void btnConActionPerformed(java.awt.event.ActionEvent evt) {
        txtObtDate.setText(f.getFecha(jdc));        
    }
    
    
    
}
