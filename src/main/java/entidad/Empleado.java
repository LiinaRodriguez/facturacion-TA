package entidad;

public class Empleado extends Persona {
    private String oficio;

    public Empleado( String nombre, String apellido, String telefono,  String correo, String carnet) {
        super( nombre,apellido, telefono, correo, carnet);
        rol = String.valueOf(this.getClass().getSimpleName());
    }

    @Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Tipo: Empleado");
        System.out.println("Oficio: " + oficio);
    }
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", "
                + "telefono=" + telefono + ", oficio=" + oficio + ", id=" + id + ", correo=" + correo + ", carnet=" + carnet + '}';
    }
    
    
}
