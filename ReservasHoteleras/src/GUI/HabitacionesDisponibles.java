/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATA.DAOHabitacion;
import LOGIC.FormatoCalendar;
import LOGIC.Habitacion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author david
 */
public class HabitacionesDisponibles extends JFrame {

    FormatoCalendar f = new FormatoCalendar();
    JTable tblHabDis = new JTable();
    JScrollPane scHabDis = new JScrollPane(tblHabDis);
    JLabel etqDis = new JLabel("Las habitaciones disponibles son: ");
    JLabel etqFecIng = new JLabel("Fecha de ingreso");
    JLabel etqFecSal = new JLabel("Fecha de salida");
    JLabel etqNoc = new JLabel("Cantidad de noches");
    JButton btnVol = new JButton("VOLVER");
    JDateChooser jdc = new JDateChooser();
    JDateChooser jdc2 = new JDateChooser();
    JTextField txtObtDate = new JTextField();
    JButton btnCon = new JButton("CONSULTAR");

    public HabitacionesDisponibles() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Consultar Habitaciones disponibles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c.setBackground(Color.DARK_GRAY);
        c.add(etqDis);
        c.add(scHabDis);
        c.add(btnVol);
        c.add(etqFecIng);
        c.add(etqFecSal);
        c.add(etqNoc);
        c.add(jdc);
        c.add(jdc2);
        c.add(txtObtDate);
        c.add(btnCon);

        etqFecIng.setBounds(50, 20, 180, 35);
        etqFecIng.setFont(new Font("dialog", 1, 16));
        etqFecIng.setForeground(Color.WHITE);
        etqFecSal.setBounds(350, 20, 180, 35);
        etqFecSal.setFont(new Font("dialog", 1, 16));
        etqFecSal.setForeground(Color.WHITE);
        jdc.setBounds(50, 60, 150, 25);
        jdc2.setBounds(350, 60, 150, 25);
        btnCon.setBounds(150, 120, 150, 50);
        btnCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnConActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(HabitacionesDisponibles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        etqDis.setBounds(50, 220, 350, 35);
        etqDis.setFont(new Font("dialoge", 1, 20));
        etqDis.setForeground(Color.WHITE);
        tblHabDis.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Número", "Tipo", "Valor", "Capacidad"
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
        setSize(550, 700);
    }

    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }

    public void btnConActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        txtObtDate.setText(f.getFecha(jdc));
        String s1 = f.getFecha(jdc);
        String s2 = f.getFecha(jdc2);
        System.out.println(s1);
        System.out.println(s2);
        mostrar_tabla();
    }

    public void mostrar_tabla() throws Exception {

        List<Habitacion> lista = (new DAOHabitacion()).recuperarDisponible("2019-03-07", "2019-03-16");
        DefaultTableModel model = (DefaultTableModel) tblHabDis.getModel();
        Object[] filas = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getN_hab();
            filas[1] = lista.get(i).getTipo().getIdTipHab();
            filas[2] = lista.get(i).getTipo().getValorNoc();
            filas[3] = lista.get(i).getTipo().getCapacidad();
            model.addRow(filas);

        }
    }
}
