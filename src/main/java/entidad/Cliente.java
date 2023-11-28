
package entidad;
import dao.*;
import metodofactory.DBType;

import java.sql.SQLException;
import java.util.List;
public class Cliente {
    public static void main(String[] args) {

        try {
            FechaHora fechaHora = new FechaHora();
            fechaHora.getFechaHora();

            ServicioDAO servicioDAO = new ServicioDAO();

            Servicio CertificadoNotasServicio = new Servicio("CertificadoNotas", "12000");
            servicioDAO.insertServicio(CertificadoNotasServicio);
            DetalleVentaServicio det = new DetalleVentaServicio("20-11-23", 2, CertificadoNotasServicio);

            DetalleVentaServicioDAO detDao = new DetalleVentaServicioDAO();
            List<DetalleVentaServicio> detalleVentaServicios = detDao.obtenerDetalleVentaServicio();
            for (DetalleVentaServicio detalleVentaServicio: detalleVentaServicios){
                System.out.println(detalleVentaServicio.toString());
            }

            detDao.eliminarDetalleVentaServicio(1);

            servicioDAO.eliminarServicio(5);
            servicioDAO.eliminarServicio(4);
            Servicio actServicio = new Servicio("Constancia de estudio", "11000");
            servicioDAO.actualizarServicio(actServicio, 6);


            System.out.println("************* - Union - ************");
            OperacionesBD uniondetalleyservicio = new OperacionesBD();
            List<DetalleVentaServicio> detalleVentaUNIONServicios = uniondetalleyservicio.obtenerUnionOjbeto();
            for(DetalleVentaServicio detalleVentaServicio: detalleVentaUNIONServicios){
                System.out.println(detalleVentaServicio.toString() + detalleVentaServicio.getServicio().toString());
            }

            System.out.println("************** - Diferencia - *************");
            List<DetalleVentaServicio> detalleVentaDIFERENCIAServicios = uniondetalleyservicio.obtenerDiferenciaOjbeto();
            for(DetalleVentaServicio detalleVentaServicio: detalleVentaDIFERENCIAServicios){
                System.out.println( detalleVentaServicio.getServicio().toString());
            }

            System.out.println("Pruebas*********************");
            ServicioDAO servicioDAO2 = new ServicioDAO(DBType.POSTGRESQL);
            List<Servicio> servicios = servicioDAO2.obtenerServicio();
            for (Servicio servicio : servicios) {
                System.out.println(servicio.toString());
            }

            ServicioDAO servicioDAO3 = new ServicioDAO(DBType.POSTGRESQL);
            List<Servicio> servicios1 = servicioDAO3.obtenerServicio();
            for (Servicio servicio : servicios1) {
                System.out.println(servicio.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
//
        }
    }
}