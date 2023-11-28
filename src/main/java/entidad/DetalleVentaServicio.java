/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author Estudiante_MCA
 */
public class DetalleVentaServicio {
    private int id;
    private String fecha;
    private int cantidad;
    private Servicio servicio;
    private static boolean encabezado = false;

    public DetalleVentaServicio( String fecha, int cantidad, Servicio servicio) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.servicio = servicio;
    }
    public DetalleVentaServicio(){}
    public void setServicio(Servicio servicio){
        this.servicio = servicio;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        StringBuilder sb = new StringBuilder();
        if (!encabezado){

            sb.append(String.format("%-5s %-20s %-10s \n", "ID", "FECHA", "CANTIDAD"));
            encabezado = true;
        }
        sb.append("--------------------------------------------------\n");

        sb.append(String.format("%-5d %-20s %-10s\n", id, fecha, cantidad));

        return sb.toString();
       // return "DetalleVentaServicio{" + "fecha=" + fecha + ", cantidad=" + cantidad + ", servicio=" + servicio.toString() + '}';
    }
    
}
