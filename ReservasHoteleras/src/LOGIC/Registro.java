/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.sql.Date;

/**
 *
 * @author estudiantes
 */
public class Registro {
    //Declaración de varibales
   private int id_registro;
   String estado;
   Date f_ingreso;
   Date f_salida;
   
   //Método constructor e inicialización de variables
   Registro(){
    id_registro=0;   
    estado = "";
    f_ingreso= new Date(0);
    f_salida= new Date(0);
   }
   
   //métodos accesores
    public int getId_registro() {
        return id_registro;
    }
    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }
   
   
   
   
}
