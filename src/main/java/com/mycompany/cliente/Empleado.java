package com.mycompany.cliente;

public class Empleado extends Persona {
    private String oficio;
    private String correo;
    private String carnet;

    public Empleado(int id, String nombre, String apellido, String telefono, String oficio, String correo, String carnet) {
        super(id, nombre,apellido, telefono);
        this.oficio= oficio;
        this.correo = correo;
        this.carnet = carnet;
    }

    public String getOficio() {
        return oficio;
    }

    public String getCorreo(){
        return correo;
    }

    public String getCarnet(){
        return carnet;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", oficio=" + oficio + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
    
    
}
