/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Huesped extends Persona {

    private Date f_nacimiento;
    private ArrayList<Registro> registros;

    public Huesped() {
        super();
        f_nacimiento = new Date(0);
        registros = new ArrayList<>();
    }
    
    public Huesped(Huesped h, Persona p) {
        super(p);
        f_nacimiento = h.getF_nacimiento();
        registros = new ArrayList<>();
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }

}
