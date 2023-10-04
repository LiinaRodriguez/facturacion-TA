
package com.mycompany.cliente;
import com.mycompany.cliente.DAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        //Conexion con la base de datos
        String jdbcUrl = "jdbc:mysql://localhost:3306/facturacion_db";
        String db_usuario = "root";
        String db_contrasena = "3c_3Za24umYfr$g";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, db_usuario, db_contrasena);

            // Iniciar la transacción
            connection.setAutoCommit(false);

            //Acceso a la base de datos
            ServicioDAO servicioDAO  = new ServicioDAO(connection);
            PersonaDAO personaDAO = new PersonaDAO(connection);
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            DetalleVentaServicioDAO detalleVentaServicioDAO = new DetalleVentaServicioDAO(connection);
            PlataformaDAO plataformaDAO = new PlataformaDAO(connection);
            UsuarioRegistradoDAO usuarioRegistradoDAO = new UsuarioRegistradoDAO(connection);
            EstudianteDAO estudianteDAO = new EstudianteDAO(connection);

            //Login
            Loginauth loginauth = new Loginauth(connection);
            boolean inicioSesion = loginauth.verificarInicioSesion("usuario34", "33inf4", 1);
            if(inicioSesion){
                System.out.print("Inicio de sesion exitoso");
                Login login = new Login();
                login.setFecha_hora(new Timestamp(System.currentTimeMillis()));
                login.setUsuarioRegistrado(loginauth.obtenerUsuarioRegistrado("usuario34", "33inf4", 1));
                loginauth.insertLogin(login);
            }

            Estudiante estudiante = new Estudiante(2,  2,"Ing Electronica");
            estudianteDAO.insertarEstudiante(estudiante);

            //Eliminar
          /*  usuarioDAO.eliminarUsuario(3);

            servicioDAO.eliminarServicio(1);

            personaDAO.eliminarPersona(1);*/


            //Actualizar
            /*Servicio actServicio = new Servicio(4,"CertificadoNotas", "15000");
            servicioDAO.actualizarServicio(actServicio, 10);

            Persona actPersona= new Persona(1, "Liliana", "Gomez", "3265671297", "", "130002672");
            personaDAO.actualizarPersona(actPersona,1 );

            Usuario actUsuario = new Usuario(6,"Lili", "asdkcme",actPersona);
            usuarioDAO.actualizarUsuario(actUsuario,10 );*/

            //Mostrar
            List<Servicio> servicios = servicioDAO.obtenerServicio();
            for(Servicio servicio : servicios){
                System.out.println(servicio.toString());
            }

            List<Usuario> usuarios = usuarioDAO.obtenerUsuario();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }

            List<Persona> personas = personaDAO.obtenerPersona();
            for (Persona persona : personas) {
                System.out.println(persona.toString());
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                // Restaurar la configuración de autocommit
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
                // Cerrar la conexión
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}