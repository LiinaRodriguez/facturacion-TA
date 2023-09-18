/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;


/**
 *
 * @author Lina Rodriguez
 */
public class UsuarioRegistrado {
private int id;
private Usuario usuario;
private Plataforma plataforma;
 
    public UsuarioRegistrado(int id, Usuario usuario, Plataforma plataforma) {
        this.id = id;
        this.usuario = usuario;
        this.plataforma = plataforma;
    }

    public int getId(){ return id; }

    public Usuario getUsuario() {
        return usuario;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setId(int id){ this.id = id; }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario + ", Plataforma: " + plataforma ;
    }
    
}
