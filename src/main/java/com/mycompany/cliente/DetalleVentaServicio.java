/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

/**
 *
 * @author Estudiante_MCA
 */
public class DetalleVentaServicio {
    private int id;
    private String fecha;
    private int cantidad;
    private Servicio servicio;

    public DetalleVentaServicio(int id, String fecha, int cantidad, Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public int getId() { return id; }
    public Servicio getServicio() {
        return servicio;
    }
    public double calculaTotalVenta(){
        return cantidad * Integer.parseInt(servicio.getPrecioServicio());
    }
    @Override
    public String toString() {
        return "DetalleVentaServicio{" + "fecha=" + fecha + ", cantidad=" + cantidad + ", servicio=" + servicio.toString() + '}';
    }
    
}
