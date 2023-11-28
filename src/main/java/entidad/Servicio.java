/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 * @author Estudiante_MCA
 */
public class Servicio {
    private int id;
    private String nombreServicio;
    private String precioServicio;
    private static boolean encabezado = false;
    
    public Servicio( String nombreServicio, String precioServicio) {
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
        StringBuilder sb = new StringBuilder();
        if (!encabezado){
        // Agregamos encabezados de la tabla
        sb.append(String.format("%-5s %-20s %-10s\n", "ID", "NOMBRE", "PRECIO"));
        encabezado = true;
        }
        sb.append("--------------------------------------------------\n");

        sb.append(String.format("%-5d %-20s %-10s\n", id, nombreServicio, precioServicio));

        return sb.toString();
        //return "Servicios" + ", Servicio: " + nombreServicio + ", Precio: " + precioServicio + "";
    }



          
}
