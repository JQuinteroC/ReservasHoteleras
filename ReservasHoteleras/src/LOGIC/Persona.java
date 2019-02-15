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
public class Persona {
    private String nombres;
    private String apellidos;
    private int documento;
    private int telfijo;
    private int telmovil;
    public String barrio;
    public String ciudad;
    public String direccion;
    public String pais;
    public String tipo;
    public Date f_nacimiento;
    public boolean rol;
    
//método constructor    
    Persona(){
        nombres="";
        apellidos="";
        barrio="";
        ciudad="";
        documento=0;
        telfijo=0;
        telmovil=0;
        direccion="";
        pais="";
        tipo="";
        f_nacimiento = new Date(0);
        rol=false;//si es huesped
    }
    
    //Métodos accesores
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(int telfijo) {
        this.telfijo = telfijo;
    }

    public int getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(int telmovil) {
        this.telmovil = telmovil;
    }

    
    
    
    
}
