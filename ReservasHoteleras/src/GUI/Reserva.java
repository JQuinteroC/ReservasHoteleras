/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author JQuintero
 */
public class Reserva extends JFrame {
    JLabel etqFInicio = new JLabel("Fecha de inicio");
    JLabel etqNoches = new JLabel("Noches");
    JLabel etqHabitaciones = new JLabel("Habitaciones disponibles:");
    JTextField textNoches = new JTextField();
    JSpinner spnFInicio = new JSpinner(new javax.swing.SpinnerDateModel());
    JTable tblHabiciones = new JTable();
    JButton btnVol = new JButton("VOLVER");
    JButton btnRes = new JButton("RESERVAR");
    JScrollPane sclP = new JScrollPane (tblHabiciones);

    public Reserva() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Reserva");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // <editor-fold defaultstate="collapsed" desc="Spinner Fecha inicio">                          
        spnFInicio.setEditor(new JSpinner.DateEditor(spnFInicio, "d/MMM/yyyy"));
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Tabla de habitaciones">                          
        tblHabiciones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "","Nombre", "Número", "Tipo", "Costo noche", "Capacidad"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                true, false, false, false, false, false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHabiciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblHabiciones.setShowVerticalLines(false);
        tblHabiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabicionesMouseClicked(evt);
            }
        }); // </editor-fold>  
        
        // <editor-fold defaultstate="collapsed" desc="Boton Volver">
         btnVol.addActionListener(this::btnVolActionPerformed); // </editor-fold>
         
         // <editor-fold defaultstate="collapsed" desc="Boton Reservar">
         btnRes.addActionListener(this::btnResActionPerformed); // </editor-fold>
         
        c.add(etqFInicio);
        c.add(etqNoches);
        c.add(etqHabitaciones);
        c.add(textNoches);
        c.add(spnFInicio);
        c.add(btnVol);
        c.add(sclP);
        c.add(btnRes);
        
        etqFInicio.setBounds(30, 30, 200, 25);
        spnFInicio.setBounds(30, 60, 100, 25);
        etqNoches.setBounds(350, 30, 200, 25);
        textNoches.setBounds(350, 60, 100, 25);
        etqHabitaciones.setBounds(30,100,200,25);
        sclP.setBounds(30,130,510,250);
        btnVol.setBounds(30, 400, 100, 35);
        btnRes.setBounds(440, 400, 100, 35);

        setSize(600,500);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Eventos Tabla de habitaciones">
    private void tblHabicionesMouseClicked(java.awt.event.MouseEvent evt) {
        // Acaba de seleccionar una habitación
    }// </editor-fold>   
    
    // <editor-fold defaultstate="collapsed" desc="Eventos boton Volver">
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    } // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Eventos boton Reservar">
    public void btnResActionPerformed(java.awt.event.ActionEvent evt) { 
        // Muestra otra ventana donde se solicita la información de la persona 
    } // </editor-fold>
}
