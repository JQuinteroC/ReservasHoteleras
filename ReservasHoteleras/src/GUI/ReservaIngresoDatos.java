/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATA.DAOHotel;
import LOGIC.Persona;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class ReservaIngresoDatos extends JFrame {

    Persona p = new Persona();
    JLabel etqNomb = new JLabel("Registro de datos");
    JLabel etqDig = new JLabel("Digite");
    JLabel etqNId = new JLabel("El numero de identificacion");
    JLabel etqTId = new JLabel("El tipo de documento");
    JLabel etqNombre = new JLabel("Sus nombres");
    JLabel etqApellido = new JLabel("Sus apellidos");
    JLabel etqPais = new JLabel("El pais");
    JLabel etqCiudad = new JLabel("La ciudad");
    JLabel etqBarrio = new JLabel("El barrio");
    JLabel etqDir = new JLabel("La direccion");
    JLabel etqTlfijo = new JLabel("El numero del telefono fijo");
    JLabel etqTlcel = new JLabel("El numero del telefono celular");
    JLabel etqNumHab = new JLabel("Numero de la habitacion disponible");
    JLabel etqNoches = new JLabel("La cantidad de noches");
    JLabel etqCanPer = new JLabel("La cantidad de personas");

    JTextField textNId = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textApellido = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textCiudad = new JTextField();
    JTextField textBarrio = new JTextField();
    JTextField textDir = new JTextField();
    JTextField textTlfijo = new JTextField();
    JTextField textTlcel = new JTextField();
    JTextField textNumHab = new JTextField();
    JTextField textNoches = new JTextField();
    JTextField textCanPer = new JTextField();
    JButton btnRes = new JButton("RESERVAR");
    JButton btnVol = new JButton("VOLVER");
    JButton btnDis = new JButton("Consultar disponibilidad");

    JComboBox<String> cbTId = new JComboBox<String>();

    public ReservaIngresoDatos() {

        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro en reserva");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setBackground(Color.DARK_GRAY);
        c.add(etqNomb);
        c.add(etqDig);
        c.add(etqNId);
        c.add(etqTId);
        c.add(etqNombre);
        c.add(etqApellido);
        c.add(etqPais);
        c.add(etqCiudad);
        c.add(etqBarrio);
        c.add(etqDir);
        c.add(etqTlfijo);
        c.add(etqTlcel);
        c.add(etqCanPer);
        c.add(etqNumHab);
        c.add(etqNoches);
        c.add(textNId);
        c.add(cbTId);
        c.add(textNombre);
        c.add(textApellido);
        c.add(textPais);
        c.add(textCiudad);
        c.add(textBarrio);
        c.add(textDir);
        c.add(textTlfijo);
        c.add(textTlcel);
        c.add(textCanPer);
        c.add(textNumHab);
        c.add(textNoches);
        c.add(btnDis);
        c.add(btnRes);
        c.add(btnVol);

        etqNomb.setBounds(50, 20, 250, 30);
        etqNomb.setFont(new Font("Montserrat", 1, 26));
        etqNomb.setForeground(Color.GREEN);
        etqDig.setBounds(50, 150, 250, 25);
        etqDig.setFont(new Font("Montserrat", 1, 22));
        etqDig.setForeground(Color.WHITE);
        etqNId.setBounds(50, 200, 300, 25);
        etqNId.setForeground(Color.white);
        etqNId.setFont(new Font("Montserrat", 1, 14));
        etqTId.setBounds(50, 230, 200, 25);
        etqTId.setForeground(Color.white);
        etqTId.setFont(new Font("Montserrat", 1, 14));
        etqNombre.setBounds(50, 260, 200, 25);
        etqNombre.setForeground(Color.white);
        etqNombre.setFont(new Font("Montserrat", 1, 14));
        etqApellido.setBounds(50, 290, 200, 25);
        etqApellido.setForeground(Color.white);
        etqApellido.setFont(new Font("Montserrat", 1, 14));
        etqPais.setBounds(50, 320, 200, 25);
        etqPais.setForeground(Color.white);
        etqPais.setFont(new Font("Montserrat", 1, 14));
        etqCiudad.setBounds(50, 350, 200, 25);
        etqCiudad.setForeground(Color.white);
        etqCiudad.setFont(new Font("Montserrat", 1, 14));
        etqBarrio.setBounds(50, 380, 200, 25);
        etqBarrio.setForeground(Color.white);
        etqBarrio.setFont(new Font("Montserrat", 1, 14));
        etqDir.setBounds(50, 410, 200, 25);
        etqDir.setForeground(Color.white);
        etqDir.setFont(new Font("Montserrat", 1, 14));
        etqTlfijo.setBounds(50, 440, 300, 25);
        etqTlfijo.setForeground(Color.white);
        etqTlfijo.setFont(new Font("Montserrat", 1, 14));
        etqTlcel.setBounds(50, 470, 300, 25);
        etqTlcel.setForeground(Color.white);
        etqTlcel.setFont(new Font("Montserrat", 1, 14));
        etqCanPer.setBounds(50, 500, 250, 25);
        etqCanPer.setForeground(Color.white);
        etqCanPer.setFont(new Font("Montserrat", 1, 14));
        etqNumHab.setBounds(50, 530, 300, 25);
        etqNumHab.setForeground(Color.white);
        etqNumHab.setFont(new Font("Montserrat", 1, 14));
        etqNoches.setBounds(50, 560, 250, 25);
        etqNoches.setForeground(Color.white);
        etqNoches.setFont(new Font("Montserrat", 1, 14));
        textNId.setBounds(400, 200, 150, 25);
        textNId.setBackground(new Color(0, 51, 51));
        textNId.setForeground(Color.white);
        textNId.setFont(new Font("Montserrat", 1, 14));
        cbTId.setBounds(400, 230, 170, 25);
        cbTId.setFont(new Font("Montserrat", 1, 14));
        cbTId.addItem("Cedula de ciudadania");
        cbTId.addItem("Tarjeta de identidad");
        cbTId.addItem("Pasaporte");
        cbTId.setSelectedIndex(-1);
        cbTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTIdActionPerformed(evt);
            }
        });
        textNombre.setBounds(400, 260, 150, 25);
        textNombre.setBackground(new Color(0, 51, 51));
        textNombre.setForeground(Color.white);
        textNombre.setFont(new Font("Montserrat", 1, 14));
        textApellido.setBounds(400, 290, 150, 25);
        textApellido.setBackground(new Color(0, 51, 51));
        textApellido.setForeground(Color.white);
        textApellido.setFont(new Font("Montserrat", 1, 14));
        textPais.setBounds(400, 320, 150, 25);
        textPais.setBackground(new Color(0, 51, 51));
        textPais.setForeground(Color.white);
        textPais.setFont(new Font("Montserrat", 1, 14));
        textCiudad.setBounds(400, 350, 150, 25);
        textCiudad.setBackground(new Color(0, 51, 51));
        textCiudad.setForeground(Color.white);
        textCiudad.setFont(new Font("Montserrat", 1, 14));
        textBarrio.setBounds(400, 380, 150, 25);
        textBarrio.setBackground(new Color(0, 51, 51));
        textBarrio.setForeground(Color.white);
        textBarrio.setFont(new Font("Montserrat", 1, 14));
        textDir.setBounds(400, 410, 150, 25);
        textDir.setBackground(new Color(0, 51, 51));
        textDir.setForeground(Color.white);
        textDir.setFont(new Font("Montserrat", 1, 14));
        textTlfijo.setBounds(400, 440, 150, 25);
        textTlfijo.setBackground(new Color(0, 51, 51));
        textTlfijo.setForeground(Color.white);
        textTlfijo.setFont(new Font("Montserrat", 1, 14));
        textTlcel.setBounds(400, 470, 150, 25);
        textTlcel.setBackground(new Color(0, 51, 51));
        textTlcel.setForeground(Color.white);
        textTlcel.setFont(new Font("Montserrat", 1, 14));
        textCanPer.setBounds(400, 500, 150, 25);
        textCanPer.setBackground(new Color(0, 51, 51));
        textCanPer.setForeground(Color.white);
        textCanPer.setFont(new Font("Montserrat", 1, 14));
        textNumHab.setBounds(400, 530, 150, 25);
        textNumHab.setBackground(new Color(0, 51, 51));
        textNumHab.setForeground(Color.white);
        textNumHab.setFont(new Font("Montserrat", 1, 14));
        textNoches.setBounds(400, 560, 150, 25);
        textNoches.setBackground(new Color(0, 51, 51));
        textNoches.setForeground(Color.white);
        textNoches.setFont(new Font("Montserrat", 1, 14));
        btnRes.setBounds(250, 650, 100, 50);
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });
        btnDis.setBounds(50, 70, 250, 35);
        btnDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisActionPerformed(evt);
            }
        });
        btnVol.setBounds(50, 650, 100, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        setVisible(true);
        setSize(700, 800);

    }

    //Es el actionPerfomed para enviar el tipo de documento
    public void cbTIdActionPerformed(java.awt.event.ActionEvent evt) {

        if ("Cedula de ciudadania".equals(cbTId.getSelectedItem().toString())) {
            p.setTipo_doc("CC");//envio la cadena de caracteres al aributo en la clase persona
            System.out.println("TIPO:" + p.getTipo_doc());
        } else {
            if ("Tarjeta de identidad".equals(cbTId.getSelectedItem().toString())) {
                p.setTipo_doc("TI");//envio la cadena de caracteres al aributo en la clase persona
                System.out.println("TIPO:" + p.getTipo_doc());
            } else {
                p.setTipo_doc("PP");//envio la cadena de caracteres al aributo en la clase persona
                System.out.println("TIPO:" + p.getTipo_doc());
            }

        }
    }

    //acciones del botón enviar
    public void btnResActionPerformed(java.awt.event.ActionEvent evt1) {
        DAOHotel dao = new DAOHotel();//se cera uan instancia de la clase que controla la bd
        String numdocu = textNId.getText();
        p.setDocumento(numdocu);
        System.out.println("Doc en persona: " + p.getDocumento());

        p.setNombres(textNombre.getText());
        System.out.println("Nombres en persona: " + p.getNombres());

        p.setApellidos(textApellido.getText());
        System.out.println("Apellidos en persona: " + p.getApellidos());

        long lg = Long.parseLong(textTlfijo.getText());
        p.setTelfijo(lg);
        System.out.println("#Fijo en persona: " + p.getTelfijo());

        long lg2 = Long.parseLong(textTlcel.getText());
        p.setTelmovil(lg2);
        System.out.println("Movil en persona: " + p.getTelmovil());

        p.setBarrio(textBarrio.getText());
        System.out.println("barrio en persona: " + p.getBarrio());

        p.setPais(textPais.getText());
        System.out.println("Pais en persona: " + p.getPais());

        p.setCiudad(textCiudad.getText());
        System.out.println("Ciudad en persona: " + p.getCiudad());

        p.setDireccion(textDir.getText());
        System.out.println("Direccion en persona: " + p.getDireccion());
        try {
            dao.resgistrarPersona(p);//se llama al metodo registrar y se le envia la persona con todos sus atributos

        } catch (Exception ex) {
            System.out.println("ERROR!!!:  " + ex.getMessage());
        }
    }

    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) {
        Menu m = new Menu();
        setVisible(false);
    }

    public void btnDisActionPerformed(java.awt.event.ActionEvent evt) {
        HabitacionesDisponibles hd = new HabitacionesDisponibles();
        btnRes.setEnabled(true);

    }

}
