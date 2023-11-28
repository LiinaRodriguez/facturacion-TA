/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

/**
 *
 * @author Lina Rodriguez
 */
public class Plataforma {
  

    private int id;
    private String plataforma;

    public Plataforma(int id, String plataforma) {
        this.id = id;
        this.plataforma = plataforma;
    }
    public Plataforma(){}
    public String getPlataforma() {
        return plataforma;
    }

    public int getId() {
        return id;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Nombre: " + plataforma ;
    }
}
