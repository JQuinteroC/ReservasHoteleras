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
 * @author J
 */
public class Cuenta {

    private int idCuenta;
    private Date fechaCre;
    private String estado;
    private double valorEst;
    private double valorCon;
    private ArrayList<Producto_Servicio> productos;
    private Registro registro;
    private Habitacion habitacion;

    public Cuenta() {
        estado = "";
        fechaCre = new Date(0);
        productos = new ArrayList<>();
        registro = new Registro();
        habitacion = new Habitacion();
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public void setIdCuenta(int cuenta) {
        this.idCuenta = cuenta;
    }

    public Date getFechaCre() {
        return fechaCre;
    }

    public void setFechaCre(Date fechaCre) {
        this.fechaCre = fechaCre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorEst() {
        return valorEst;
    }

    public void setValorEst(double valorEst) {
        this.valorEst = valorEst;
    }

    public double getValorCon() {
        return valorCon;
    }

    public void setValorCon(double valorCon) {
        this.valorCon = valorCon;
    }

    public ArrayList<Producto_Servicio> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto_Servicio> productos) {
        this.productos = productos;
    }

}
