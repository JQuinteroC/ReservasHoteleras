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
    private int ocupantes;
    private String estado;
    private Persona persona;
    private Habitacion habitacion;

    //método constructor
    public Reserva() {
        f_inicio = new Date(0);
        f_reserva = new Date(0);
        id_reserva = 0;
        estado = "";
        dias = 0;
        ocupantes = 0;
        persona = new Persona();
        habitacion = new Habitacion();
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Date getF_reserva() {
        return f_reserva;
    }

    public void setF_reserva(Date f_reserva) {
        this.f_reserva = f_reserva;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
}
