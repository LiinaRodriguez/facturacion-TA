/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.sql.Timestamp;

/**
 *
 * @author Lina Rodriguez
 */

public class Login{
    private int id;
    private Timestamp fecha_hora;
    private UsuarioRegistrado usuarioRegistrado;

    public Login(int id, Timestamp fecha_hora, UsuarioRegistrado usuarioRegistrado) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.usuarioRegistrado = usuarioRegistrado;
    }
    public Login(){}

    public int getId() {
        return id;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public UsuarioRegistrado getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public void setUsuarioRegistrado(UsuarioRegistrado usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public void iniciarSesion(boolean inicioSesion){
        if (inicioSesion == true){System.out.println("Inicio de sesion exitoso");    } //crea un objeto login y lo guarda en la base de datos
    }
}
