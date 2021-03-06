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
 * @author estudiantes
 */
public class Registro {

    //Declaración de varibales
    private int id_registro;
    private String estado;
    private Date f_ingreso;
    private Date f_salida;
    private ArrayList<Huesped> ocupantes;
    private Reserva reserva;
    private Habitacion habitacion;

    //Método constructor e inicialización de variables
    public Registro() {
        id_registro = 0;
        estado = "";
        f_ingreso = new Date(0);
        f_salida = new Date(0);
        ocupantes = new ArrayList<>();
        reserva = new Reserva();
        habitacion = new Habitacion();
    }

    //métodos accesores
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public ArrayList<Huesped> getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(ArrayList<Huesped> ocupantes) {
        this.ocupantes = ocupantes;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(Date f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public Date getF_salida() {
        return f_salida;
    }

    public void setF_salida(Date f_salida) {
        this.f_salida = f_salida;
    }

}
