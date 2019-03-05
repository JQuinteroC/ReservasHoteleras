/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

/**
 *
 * @author estudiantes
 */
public class Habitacion {

    private int n_hab;
    private String estado;
    private TipoHab tipo;

    Habitacion() {
        n_hab = 0;
        estado = "";
    }

    public TipoHab getTipo() {
        return tipo;
    }

    public void setTipo(TipoHab tipo) {
        this.tipo = tipo;
    }

    public int getN_hab() {
        return n_hab;
    }

    public void setN_hab(int n_hab) {
        this.n_hab = n_hab;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
