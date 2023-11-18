
package com.mycompany.cliente;
import com.mycompany.cliente.DAO.Conexion;
import com.mycompany.cliente.DAO.DetalleVentaServicioDAO;
import com.mycompany.cliente.DAO.PersonaDAO;
import com.mycompany.cliente.DAO.Loginauth;
import com.mycompany.cliente.DAO.EstudianteDAO;
import com.mycompany.cliente.DAO.DetalleVentaServicioDAO;
import com.mycompany.cliente.DAO.ServicioDAO;
import com.mycompany.cliente.DAO.PlataformaDAO;
import com.mycompany.cliente.DAO.UsuarioDAO;
import com.mycompany.cliente.DAO.UsuarioRegistradoDAO;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        Conexion conexionDB = new Conexion();

        try {
            conexionDB.iniciarTransaccion();

            //Acceso a la base de datos
            ServicioDAO servicioDAO = new ServicioDAO(conexionDB.obtenerConexion());
            PersonaDAO personaDAO = new PersonaDAO(conexionDB.obtenerConexion());
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexionDB.obtenerConexion());

            Estudiante estudiante = new Estudiante(1007869412, "Sofia", "Moreno", "312465845",
                    "sofia.moreno@unillanos.edu.co", "160004457", 4, "Ingenieria Electrónica" );
            Empleado empleado = new Empleado(105267489, "Natalia", "Zamora", "315624852",
                    "natalia.zamora@unillanos.edu.co", "160004102", "Secretaria");
            Docente docente = new Docente(1014978352, "Maykoll", "Gutierrez", "3156487295",
                    "Facultad de Ciecias Básicas", "maykoll.gutierrez@unillanos.edu.co", "160004507");

            estudiante.imprimirInformacion();
            System.out.println("\n ---- \n");
            docente.imprimirInformacion();
            System.out.println("\n ---- \n");
            empleado.imprimirInformacion();
            System.out.println("\n ---- \n");

          /*boolean inicioSesion = loginauth.verificarInicioSesion("usuario34", "33inf4", 1);
            loginauth.iniciarSesion(inicioSesion, Usuario);*/

            //Mostrar
            List<Servicio> servicios = servicioDAO.obtenerServicio();
            for (Servicio servicio : servicios) {
                System.out.println(servicio.toString());
            }
            System.out.println("\n ---- \n");
            List<Usuario> usuarios = usuarioDAO.obtenerUsuario();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());

            }
            System.out.println("\n ---- \n");
            List<Persona> personas = personaDAO.obtenerPersona();
            for (Persona persona : personas) {
                System.out.println(persona.toString());
            }

            conexionDB.confirmarTransaccion();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexionDB != null) {
                    conexionDB.revertirTransaccion();
                }
            } finally {
                try {
                    // Cerrar la conexión
                    if (conexionDB != null) {
                        conexionDB.cerrarConexion();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}