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
public class Pago {
    //declaración de variables 
    private int id_pago;
    public Date f_pago;
    public String medio_pago;
    public double valor;
    
   //método constructor
    Pago (){
        id_pago=0;
        f_pago = new Date(0);
        medio_pago="";
        valor=0;
    }
    
    //métodos accesores

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }
    
}
