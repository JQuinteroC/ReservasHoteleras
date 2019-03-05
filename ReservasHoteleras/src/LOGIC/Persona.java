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
public class Persona {
    //RegistroSinReserva datos = new RegistroSinReserva();

    private String nombres;
    private String apellidos;
    private String documento;
    private long telfijo;
    private long telmovil;
    private String barrio;
    private String ciudad;
    private String direccion;
    private String pais;
    private String tipo_doc;
    private boolean huesped;
    private int edad;

//método constructor    
    public Persona() {
        nombres = "";
        apellidos = "";
        barrio = "";
        ciudad = "";
        documento = "";
        telfijo = 0;
        telmovil = 0;
        direccion = "";
        pais = "";
        tipo_doc = "";
        huesped = false;
        edad = 0;
    }

    //Métodos accesores
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public boolean isHuesped() {
        return huesped;
    }

    public void setHuesped(boolean huesped) {
        this.huesped = huesped;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public long getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(long telfijo) {
        this.telfijo = telfijo;
    }

    public long getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(long telmovil) {
        this.telmovil = telmovil;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }
}
