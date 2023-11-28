package entidad;

public class PersonaCargo {
    
    private Persona persona;
    private Cargo cargo;
    private Empresa empresa;

    public PersonaCargo(Persona persona, Cargo cargo, Empresa empresa) {
        this.persona = persona;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public Persona getPersona() {
        return persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "PersonaCargo{" + "persona=" + persona + ", cargo=" + cargo + ", empresa=" + empresa + '}';
    }

}
