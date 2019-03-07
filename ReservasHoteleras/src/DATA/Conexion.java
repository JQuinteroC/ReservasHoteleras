/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Conexion {

    private static Conexion instance;
    private Connection conexion;
    private final String user = "final";//esquema de la bd
    private final String pass = "1234";//clave del esquema
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";

    private Conexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(url, user, pass);
            conexion.setAutoCommit(false);
            if (conexion != null) {
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Conexion Fallida!!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "CONEXION FALLIDA!" + e.getMessage());
        }
    }

    public static Conexion getInstance() {
        if (instance == null) {
            try {
                instance = new Conexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    public void desconexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar " + e.getMessage());
        }
    }

    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
