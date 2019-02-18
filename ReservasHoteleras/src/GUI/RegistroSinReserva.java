/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import LOGIC.Persona;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author estudiantes
 */
public class RegistroSinReserva extends JFrame{
    Persona p = new Persona();
    JLabel etqNId = new JLabel("Digite el numero de identificacion");
    JLabel etqTId = new JLabel("Digite el tipo de documento");
    JLabel etqNombre = new JLabel("Digite sus nombres");
    JLabel etqApellido = new JLabel("Digite sus apellidos");
    JLabel etqPais = new JLabel("Digite el pais donde reside");
    JLabel etqCiudad = new JLabel("Digite la ciudad donde reside");
    JLabel etqBarrio = new JLabel("Digite el barrio donde reside");
    JLabel etqDir = new JLabel("Digite la direccion donde reside");
    JLabel etqTlfijo = new JLabel("Digite el numero del telefono fijo");
    JLabel etqTlcel = new JLabel("Digite el numero del telefono celular");
    JTextField textNId = new JTextField();
    JTextField textNombre = new JTextField();
    JTextField textApellido = new JTextField();
    JTextField textPais = new JTextField();
    JTextField textCiudad = new JTextField();
    JTextField textBarrio = new JTextField();
    JTextField textDir = new JTextField();
    JTextField textTlfijo = new JTextField();
    JTextField textTlcel = new JTextField();
    JButton btnEnv = new JButton("ENVIAR");
    JButton btnVol = new JButton("VOLVER");
    JButton btnDis = new JButton("Consultar disponibilidad");
    
    
    JComboBox<String> cbTId = new JComboBox<String>();
    
    public RegistroSinReserva() {
            
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("Registro sin reserva");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        c.add(btnDis);
        c.add(btnEnv);
        c.add(btnVol);
        
        
        etqNId.setBounds(50, 100, 200, 25);
        etqTId.setBounds(50, 130, 200, 25);
        etqNombre.setBounds(50, 160, 200, 25);
        etqApellido.setBounds(50, 190, 200, 25);
        etqPais.setBounds(50, 220, 200, 25);
        etqCiudad.setBounds(50, 250, 200, 25);
        etqBarrio.setBounds(50, 280, 200, 25);
        etqDir.setBounds(50, 310, 200, 25);
        etqTlfijo.setBounds(50, 340, 200, 25);
        etqTlcel.setBounds(50, 370, 250, 25);
        textNId.setBounds(300,100,150,25);
        cbTId.setBounds(300, 130, 200, 25);
        cbTId.addItem("Cedula de ciudadania");
        cbTId.addItem("Tarjeta de identidad");
        cbTId.addItem("Pasaporte");
        cbTId.setSelectedIndex(-1);
        cbTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTIdActionPerformed(evt);
            }
        });
        textNombre.setBounds(300,160,150,25);
        textApellido.setBounds(300,190,150,25);
        textPais.setBounds(300,220,150,25);
        textCiudad.setBounds(300,250,150,25);
        textBarrio.setBounds(300,280,150,25);
        textDir.setBounds(300,310,150,25);
        textTlfijo.setBounds(300,340,150,25);
        textTlcel.setBounds(300,370,150,25);
        btnEnv.setBounds(250, 400, 250, 35);
        btnEnv.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEnvActionPerformed(evt);
        }
        });
        btnDis.setBounds(50, 50, 250, 35);
        btnVol.setBounds(50, 400, 100, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });
        
        
       
        btnEnv.setEnabled(true);
        setVisible(true);
        setSize(600,600);
        
        
    }
    
    //Es el actionPerfomed para enviar el tipo de documento
    public void cbTIdActionPerformed(java.awt.event.ActionEvent evt) {
        
        if ("Cedula de ciudadania".equals(cbTId.getSelectedItem().toString())){
        p.tipo_doc="CC";//envio la cadena de caracteres al aributo en la calse persona
        System.out.println("TIPO:"+p.tipo_doc);
        }
        
        else {
            if ("Tarjeta de identidad".equals(cbTId.getSelectedItem().toString())){
             p.tipo_doc="TI";//envio la cadena de caracteres al aributo en la clase persona
             System.out.println("TIPO:"+p.tipo_doc);
        }
            else{
             p.tipo_doc="PP";//envio la cadena de caracteres al aributo en la calse persona
             System.out.println("TIPO:"+p.tipo_doc);
            }
            
        } 
    }
     public void btnEnvActionPerformed(java.awt.event.ActionEvent evt1) {
        int numdocu = Integer.parseInt(textNId.getText());
        p.setDocumento(numdocu);
        System.out.println("Doc en persona: "+p.getDocumento());
        
        p.setNombres(textNombre.getText());
        System.out.println("Nombres en persona: "+p.getNombres());
        
        p.setApellidos(textApellido.getText());
        System.out.println("Apellidos en persona: "+p.getApellidos());
        
        long lg = Long.parseLong(textTlfijo.getText());
        p.setTelfijo(lg);
        System.out.println("#Fijo en persona: "+p.getTelfijo());
        
        long lg2 = Long.parseLong(textTlcel.getText());
        p.setTelmovil(lg2);
        System.out.println("Movil en persona: "+p.getTelmovil());
        
        p.barrio=textBarrio.getText();
        System.out.println("barrio en persona: "+p.barrio);
        
        p.pais=textPais.getText();
        System.out.println("Pais en persona: "+p.pais);
        
        p.ciudad=textCiudad.getText();
        System.out.println("Ciudad en persona: "+p.ciudad);
        
       p.direccion=textDir.getText();
        System.out.println("Direccion en persona: "+p.direccion);
        
    }
     
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) { 
        Menu m = new Menu();
        setVisible(false);       
    }
   
    
}
