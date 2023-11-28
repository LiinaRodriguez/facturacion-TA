package entidad;

public class Cargo {
    
    private String cargo;

    public Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargo=" + cargo + '}';
    }
    
    
}
