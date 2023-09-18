package com.mycompany.cliente;

public class Persona {

    protected  int id;
    protected String nombre;
    protected String correo;
    protected String apellido;
    protected String telefono;
    
    public Persona(int id, String nombre, String apellido, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public Persona(){
    }
    public void setId(int id){ this.id = id; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId(){ return id; }
    public String getNombre(){
    return nombre;
}

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Persona " + "nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono + "";
    }


}

