package com.mycompany.cliente;

public class Docente extends Persona {
    
    private String Facultad;
    private String correo;
    private String carnet;

    public Docente(int id, String nombre, String apellido, String telefono, String Facultad, String correo, String carnet) {
        super(id, nombre, apellido, telefono, correo, carnet);
        this.Facultad = Facultad;
        this.id = id;
    }

    public String getFacultad() {
        return Facultad;
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
