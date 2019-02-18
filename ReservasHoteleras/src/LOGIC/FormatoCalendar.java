/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author david
 */
public class FormatoCalendar {
    // esto es para ajustar y obtener la fecha
    SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");

    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public Date StringADate(String fecha) {
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaE = null;
        try {
            fechaE = formato_del_Texto.parse(fecha);
            return fechaE;
        } catch (ParseException ex) {
            return null;
        }
    }
    
}
