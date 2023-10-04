/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

public class Estudiante extends Persona {
    private int semestre;
//    private String correo;
    private String carrera;

    public Estudiante(int id, String nombre, String apellido, String telefono, String correo, String carnet, int semestre, String carrera) {
        super(id, nombre,apellido, telefono, correo, carnet);
        this.semestre = semestre;
        this.carrera = carrera;
    }
    public Estudiante(int id, int semestre, String carrera){
        super(id);
        this.semestre = semestre;
        this.carrera = carrera;
    }
    public int getSemestre() {
        return semestre;
    }

    public String getCarrera(){
        return carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", semestre=" + semestre + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
}
