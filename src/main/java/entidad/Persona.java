package entidad;

public class Persona {

    protected  int id;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String correo;
    protected String carnet;
    protected String rol;

    public Persona( String nombre, String apellido, String telefono, String correo, String carnet){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.carnet = carnet;

    }
    public Persona(int id){
        this.id = id;
    }
    public  Persona(){}
    public void setId(int id){ this.id = id; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getId(){ return id; }
    public String getNombre(){
    return nombre;
}

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public void imprimirInformacion(){
        System.out.println("Información básica de la persona");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Telefono: " + telefono);
    }

    @Override
    public String toString() {
        return "Persona " + "nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono + "";
    }


}

