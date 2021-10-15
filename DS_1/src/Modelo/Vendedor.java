/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rzagza
 */
public class Vendedor {
    
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String uruario;
    private String estado;

    public Vendedor() {
    }

    public Vendedor(int id, String cedula, String nombre, String apellido, String telefono, String uruario, String estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.uruario = uruario;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getCedula() {
        return cedula;
    }

    public void setCedula(String nombre) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUruario() {
        return uruario;
    }

    public void setUruario(String uruario) {
        this.uruario = uruario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
