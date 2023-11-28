package entidad;

public class Docente extends Persona {

    public Docente( String nombre, String apellido, String telefono, String correo, String carnet) {
        super( nombre, apellido, telefono, correo, carnet);
        rol = String.valueOf(this.getClass().getSimpleName());
    }

    public String getCarnet() {
        return carnet;
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Tipo: Docente");

    }
    @Override
    public String toString() {
        return "Docente{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", Facultad="  + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet +'}';
    }

   
}
