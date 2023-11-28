/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

public class Estudiante extends Persona {
    private int semestre;
    private String carrera;

    public Estudiante( String nombre, String apellido, String telefono, String correo, String carnet) {
        super(nombre,apellido, telefono, correo, carnet);
        rol = String.valueOf(this.getClass().getSimpleName());
    }
    public Estudiante(int id, int semestre, String carrera){
        super(id);
        this.semestre = semestre;
        this.carrera = carrera;
    }
    public int getSemestre() {
        return semestre;
    }

    public String getCarrera(){
        return carrera;
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Tipo: Estudiante");
        System.out.println("Carrera: " + carrera);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", semestre=" + semestre + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
}
