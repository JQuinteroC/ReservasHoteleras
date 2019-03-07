/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.util.Objects;

/**
 *
 * @author estudiantes
 */
public class Producto_Servicio {

    //Declaración de variables 
    private String descripcion;
    private int id_producto;
    private String nombre;
    private String tipo;
    private double precio_unidad;
    private int existencias;

    //Método constructor
    public Producto_Servicio() {
        descripcion = "";
        id_producto = 0;
        nombre = "";
        tipo = "";
        precio_unidad = 0;
        existencias = 0;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_producto;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto_Servicio other = (Producto_Servicio) obj;
        if (this.id_producto != other.id_producto) {
            return false;
        }
        return true;
    }

}
