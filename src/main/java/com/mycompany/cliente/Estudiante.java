/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

public class Estudiante extends Persona {
    private String semestre;
    private String id;
    private String correo;
    private String carnet;

    public Estudiante(String nombre, String apellido, String telefono, String semestre, String id, String correo, String carnet) {
        super(nombre,apellido, telefono);
        this.semestre = semestre;
        this.id = id;
        this.correo = correo;
        this.carnet = carnet;
    }

    public String getSemestre() {
        return semestre;
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
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", semestre=" + semestre + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
}
