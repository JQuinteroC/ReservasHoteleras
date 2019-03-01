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
public class Conection {

  Connection conexion;
private  String user = "troll";//esquema de la bd
private  String pass = "troll";//clave del esquema
private  String url = "jdbc:oracle:thin:@localhost:1521:xe";
public Connection conectar () throws SQLException, ClassNotFoundException{
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conexion = DriverManager.getConnection(url, user, pass);
        conexion.setAutoCommit(false);
        if(conexion != null){
            System.out.println("Conexion Exitosa");
        }else{
            System.out.println("Conexion Fallida!!");
        }
        
    }catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, "CONEXION FALLIDA!"+e.getMessage());
    }
    
    return conexion;

  }  
   
 public void desconexion(){
     try{
         conexion.close();
     }catch(Exception e){
         System.out.println("Error al desconectar "+e.getMessage());   
     }
 }
 
}
