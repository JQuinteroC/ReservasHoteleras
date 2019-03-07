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
    private TipoHab tipo;

    public Habitacion() {
        n_hab = 0;
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

    @Override
    public String toString() {
        return "\nHabitacion: [" + n_hab + ", " + tipo.toString() + ']';
    }

}
