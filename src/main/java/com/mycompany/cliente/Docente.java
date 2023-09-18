package com.mycompany.cliente;

public class Docente extends Persona {
    
    private String Facultad;
    private String id;
    private String correo;
    private String carnet;

    public Docente(String nombre, String apellido, String telefono, String Facultad, String id, String correo, String carnet) {
        super(nombre, apellido, telefono);
        this.Facultad = Facultad;
        this.id = id;
        this.correo =correo;
        this.carnet = carnet;
    }

    public String getFacultad() {
        return Facultad;
    }

    public String getId() {
        return id;
    }
  
    public String getCorreo(){
        return correo;
    }

    public String getCarnet(){
        return carnet;
    }

    @Override
    public String toString() {
        return "Docente{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", Facultad=" + Facultad + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet +'}';
    }

   
}
