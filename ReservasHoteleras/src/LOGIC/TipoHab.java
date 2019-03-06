/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author J
 */
public class TipoHab {

    private String idTipHab;
    private double valorNoc;
    private int capacidad;

    public TipoHab() {
        idTipHab = "";
    }

    public String getIdTipHab() {
        return idTipHab;
    }

    public void setIdTipHab(String idTipHab) {
        this.idTipHab = idTipHab;
    }

    public double getValorNoc() {
        return valorNoc;
    }

    public void setValorNoc(double valorNoc) {
        this.valorNoc = valorNoc;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
