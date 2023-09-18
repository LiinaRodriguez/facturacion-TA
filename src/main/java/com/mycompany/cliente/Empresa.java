package com.mycompany.cliente;

public class Empresa {
    
    private String nombre;
    private String telefono;
    private String direccion;

    public Empresa(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
}
