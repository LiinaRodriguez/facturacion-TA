/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

/**
 *
 * @author Estudiante_MCA
 */
public class VentaServicio {
    private DetalleVentaServicio detalleVenta;
    private Persona cliente;
    
    public VentaServicio(DetalleVentaServicio detalleVenta, Persona cliente) {
        this.detalleVenta = detalleVenta;
        this.cliente = cliente;
    }

    public DetalleVentaServicio getDetalleVenta() {
        return detalleVenta;
    }

    public Persona getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "VentaServicio{" + "detalleVenta=" + detalleVenta.toString() + ", cliente=" + cliente.toString() + '}';
    }

    
    }
