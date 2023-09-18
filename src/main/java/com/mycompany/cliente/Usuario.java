/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

/**
 *
 * @author Lina Rodriguez
 */
public class Usuario{

    private int id;
    private String usuario;
    private String password;
    private Persona persona;

    public Usuario(int id, String usuario, String password, Persona persona) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.persona = persona;
    }

    public Usuario (){
        //Constructor vacio//
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public String toString() {
        return "Nombre: " + usuario + " password: " + password;
    }
    
}
