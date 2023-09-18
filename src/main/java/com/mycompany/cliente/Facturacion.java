/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cliente;

/**
 *
 * @author Estudiante_MCA
 */


public class Facturacion {

    private int numero_factura;
    private VentaServicio venta;
     

    public Facturacion(int numero_factura, VentaServicio venta) {
        this.numero_factura = numero_factura;
        this.venta = venta; 
    }
    
//    public String crear_factura(){
//        
//         System.out.println("FACTURA\nun");
////        System.out.println("Nombre servicio: " + venta.getDetalleVenta().getServicio().getNombreServicio() +"\nun");
////        System.out.println("Numero de servicios: " + venta.getDetalleVenta().getCantidad() + "\nun");
////        System.out.println("");
//                
//        
//    }

    @Override
    public String toString() {
        return "Facturacion{" + "numero_factura=" + numero_factura + ", venta=" + venta.toString() + '}';
    }

   
        
}
