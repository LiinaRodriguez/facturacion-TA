
package com.mycompany.cliente;
import com.mycompany.cliente.DAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

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

            //Nuevo Servicio
            /*Servicio servicio1 = new Servicio(3,"Carnet", "2000");
            servicioDAO.insertServicio(servicio1);*/

            //Nueva DetalleVentaServicio
            /*DetalleVentaServicio detalleventaservicio = new DetalleVentaServicio(1, "02-10-23", 2, servicio1);
            detalleVentaServicioDAO.insertDetalleVentaServicio(detalleventaservicio);*/

            //Nueva plataforma
           /* Plataforma plataforma = new Plataforma(1, "SIAU");
            plataformaDAO.insertarPlataforma(plataforma);*/

            //Nueva persona
           /* Persona nuevaPersona = new Persona();
            nuevaPersona.setId(1);
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellido("Marin");
            nuevaPersona.setTelefono("3140367472");
            personaDAO.insertPersona(nuevaPersona);*/

            //Nuevo usuario
            /*Usuario nuevoUsuario = new Usuario(1, "usuario34", "33inf4", nuevaPersona);
            usuarioDAO.insertarUsuario(nuevoUsuario);*/

            //Nuevo usuario registrado
            /*UsuarioRegistrado usuarioRegistrado = new UsuarioRegistrado(1,nuevoUsuario, plataforma);
            usuarioRegistradoDAO.insertarUsuarioRegistrado(usuarioRegistrado);*/

            //Login
            /*Loginauth loginauth = new Loginauth(connection);
            boolean inicioSesion = loginauth.verificarInicioSesion("usuario34", "33inf4", 1);
            if(inicioSesion){
                System.out.print("Inicio de sesion exitoso");
                Login login = new Login();
                login.setFecha_hora(new Timestamp(System.currentTimeMillis()));
                login.setUsuarioRegistrado(loginauth.obtenerUsuarioRegistrado("usuario34", "33inf4", 1));
                loginauth.insertLogin(login);
            }*/

            //Insertar
            /* Usuario nuevoUsuario = new Usuario("usuario34", "33inf4");
            usuarioDAO.insertarUsuario(nuevoUsuario);

            Servicio nuevoServicio = new Servicio("Certificado", "11000");
            servicioDAO.insertServicio(nuevoServicio);

            Persona nuevaPersona = new Persona("Carlos", "Marin", "3140367472");
            personaDAO.insertPersona(nuevaPersona);*/

            //Eliminar
            /*usuarioDAO.eliminarUsuario(3);

            servicioDAO.eliminarServicio(1);

            personaDAO.eliminarPersona(1);
            */

            //Actualizar
            /*Servicio actServicio = new Servicio("CertificadoNotas", "15000");
            servicioDAO.actualizarServicio(actServicio, 10);

            Persona actPersona= new Persona("Liliana", "Gomez", "3204671297");
            personaDAO.actualizarPersona(actPersona,10 );

            Usuario actUsuario = new Usuario("Lili", "asdkcme");
            usuarioDAO.actualizarUsuario(actUsuario,10 );*/

            //Mostrar
            /*List<Servicio> servicios = servicioDAO.obtenerServicio();
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
            }*/
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