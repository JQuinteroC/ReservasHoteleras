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
public class Reserva {
    
    private int id_reserva;
    private Date f_inicio;
    private Date f_reserva;
    private int dias;
    String estado;
//método constructor
Reserva(){
    f_inicio = new Date(0);
    f_reserva = new Date(0);
    id_reserva=0;
    estado="";
    dias=0;
}

    
    
}
