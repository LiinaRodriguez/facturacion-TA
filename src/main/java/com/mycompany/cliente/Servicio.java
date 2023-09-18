/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

/**
 *
 * @author Estudiante_MCA
 */
public class Servicio {
    private int id;
    private String nombreServicio;
    private String precioServicio;
    
    public Servicio(int id, String nombreServicio, String precioServicio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }

    public Servicio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecioServicio(String precioServicio) {
        this.precioServicio = precioServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public String getPrecioServicio() {
        return precioServicio;
    }

    @Override
    public String toString() {
        return "Servicios" + ", Servicio: " + nombreServicio + ", Precio: " + precioServicio + "";
    }

          
}
