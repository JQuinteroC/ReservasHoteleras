/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class RegistroConReserva extends JFrame{
    JLabel etqDig = new JLabel("Digite el numero de reserva asignado");
    JTextField txtNumRes = new JTextField();
    JButton btnReg = new JButton("REGISTRAR");
    JButton btnVol = new JButton("VOLVER");

    public RegistroConReserva(){
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro con reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        c.add(etqDig);
        c.add(txtNumRes);
        c.add(btnReg);
        c.add(btnVol);
        
        etqDig.setBounds(50, 50, 240, 35);
        txtNumRes.setBounds(330, 50, 150, 35);
        btnReg.setBounds(50, 130, 150, 35);
        btnVol.setBounds(250, 130, 150, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        setVisible(true);
        setSize(525,280);        
    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Pregunta p = new Pregunta();
        setVisible(false);       
    }
    
}
