package com.mycompany.cliente;

public class Empleado extends Persona {
    private String oficio;

    public Empleado(int id, String nombre, String apellido, String telefono,  String correo, String carnet, String oficio) {
        super(id, nombre,apellido, telefono, correo, carnet);
        this.oficio= oficio;
    }

    public String getOficio() {
        return oficio;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", oficio=" + oficio + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
    
    
}
