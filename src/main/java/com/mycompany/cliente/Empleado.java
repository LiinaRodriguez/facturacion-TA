package com.mycompany.cliente;

public class Empleado extends Persona {
    private String oficio;
    private String id;
    private String correo;
    private String carnet;

    public Empleado(String nombre, String apellido, String telefono, String oficio, String id, String correo, String carnet) {
        super(nombre,apellido, telefono);
        this.oficio= oficio;
        this.id = id;
        this.correo = correo;
        this.carnet = carnet;
    }

    public String getOficio() {
        return oficio;
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
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", oficio=" + oficio + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
    
    
}
