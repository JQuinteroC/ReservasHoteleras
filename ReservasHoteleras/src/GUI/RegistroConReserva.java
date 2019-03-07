/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATA.DAOHuesped;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import DATA.DAOReserva;
import LOGIC.FormatoCalendar;
import LOGIC.Huesped;
import LOGIC.Reserva;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class RegistroConReserva extends JFrame {
    FormatoCalendar f = new FormatoCalendar();
    JLabel etqDig = new JLabel("Digite el numero de reserva asignado");
    JLabel etqNId = new JLabel("El numero de identificacion");
    JLabel etqTId = new JLabel("El tipo de documento");
    JLabel etqFNac = new JLabel("La fecha de nacimiento");
    JTextField textNId = new JTextField();
    JTextField txtNumRes = new JTextField();
    JTextField textFNac = new JTextField();
    JDateChooser jdc = new JDateChooser();
    JButton btnReg = new JButton("REGISTRAR");
    JButton btnVol = new JButton("VOLVER");
    JComboBox<String> cbTId = new JComboBox<String>();

    public RegistroConReserva() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro con reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setBackground(Color.DARK_GRAY);

        c.add(etqDig);
        c.add(etqNId);
        c.add(etqTId);
        c.add(etqFNac);
        c.add(txtNumRes);
        c.add(textNId);
        c.add(jdc);
        c.add(cbTId);
        c.add(btnReg);
        c.add(btnVol);

        etqDig.setBounds(50, 50, 300, 35);
        etqDig.setFont(new Font("dialog", 1, 16));
        etqDig.setForeground(Color.white);
        etqNId.setBounds(50, 100, 300, 25);
        etqNId.setForeground(Color.white);
        etqNId.setFont(new Font("Montserrat", 1, 14));
        etqTId.setBounds(50, 130, 200, 25);
        etqTId.setForeground(Color.white);
        etqTId.setFont(new Font("Montserrat", 1, 14));
        etqFNac.setBounds(50, 160, 250, 25);
        etqFNac.setForeground(Color.white);
        etqFNac.setFont(new Font("Montserrat", 1, 14));
        txtNumRes.setBounds(380, 50, 170, 35);
        txtNumRes.setBackground(new Color(0, 51, 51));
        txtNumRes.setForeground(Color.white);
        txtNumRes.setFont(new Font("Montserrat", 1, 14));
        txtNumRes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                try {
                    txtNumResFocusLost(evt);
                } catch (Exception ex) {
                    Logger.getLogger(RegistroConReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        textNId.setBounds(380, 100, 170, 25);
        textNId.setBackground(new Color(0, 51, 51));
        textNId.setForeground(Color.white);
        textNId.setFont(new Font("Montserrat", 1, 14));
        cbTId.setBounds(380, 130, 170, 25);
        cbTId.setFont(new Font("Montserrat", 1, 14));
        cbTId.addItem("Cedula de ciudadania");
        cbTId.addItem("Tarjeta de identidad");
        cbTId.addItem("Pasaporte");
        cbTId.setSelectedIndex(-1);
        jdc.setBounds(380,160,170,25);
        jdc.setFont(new Font("Montserrat", 1, 14));
   //     textFNac.setBounds(400, 160, 150, 25);
   //     textFNac.setBackground(new Color(0, 51, 51));
   //     textFNac.setForeground(Color.white);
   //     textFNac.setFont(new Font("Montserrat", 1, 14));

        btnReg.setBounds(50, 230, 150, 35);
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnRegActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(RegistroConReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnVol.setBounds(250, 230, 150, 35);
        btnReg.setBounds(50, 250, 150, 35);
        btnVol.setBounds(250, 250, 150, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });

        setVisible(true);
        setSize(600, 400);
    }

    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) {
        Pregunta p = new Pregunta();
        setVisible(false);
    }

    private void txtNumResFocusLost(java.awt.event.FocusEvent evt) throws Exception {
        if (!"".equals(txtNumRes.getText())) {
            DAOReserva daoRS = new DAOReserva();
            LOGIC.Reserva res = new Reserva();
            res.setId_reserva(Integer.parseInt(txtNumRes.getText()));
            res = new Reserva(daoRS.recuperar(res));
            if (res.getPersona().getTipo_doc() == "") {
                JOptionPane.showMessageDialog(null, "El número de reserva ingresado, no corresponde a una reserva actual");
                txtNumRes.setText("");
                txtNumRes.requestFocus();
            } else {
                textNId.setText(res.getPersona().getDocumento());
                switch (res.getPersona().getTipo_doc()) {
                    case "CC":
                        cbTId.setSelectedIndex(0);
                        break;
                    case "PP":
                        cbTId.setSelectedIndex(2);
                        break;
                    case "TI":
                        cbTId.setSelectedIndex(1);
                        break;
                }
                jdc.requestFocus();
            }
        }
    }

    public void btnRegActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        if (!"".equals(txtNumRes.getText()) && !"".equals(textNId.getText()) && cbTId.getSelectedIndex() != -1 && f.getFecha(jdc) != null) {
            //Actualizar reserva y tener información de la reserva
            DAOReserva daoRS = new DAOReserva();
            LOGIC.Reserva res = new Reserva();
            res.setId_reserva(Integer.parseInt(txtNumRes.getText()));
            res = new Reserva(daoRS.recuperar(res));
            res.setEstado("pagado");
            daoRS.actualizar(res);
            //Guardar huesped
            DAOHuesped daoHu = new DAOHuesped();
            Huesped hu = new Huesped();
            hu.setF_nacimiento(Date.valueOf(f.getFecha(jdc)));
            hu.setDocumento(res.getPersona().getDocumento());
            hu.setTipo_doc(res.getPersona().getTipo_doc());
            daoHu.incluir(hu);
            
            if (res.getOcupantes() > 1) {
                RegistroAcompañantes ra = new RegistroAcompañantes();
                setVisible(false);
            } else {
                //Llenar huesped
            }
        } else{
            JOptionPane.showMessageDialog(null, "¡Hay campos vacios!");
        }
    }

}
