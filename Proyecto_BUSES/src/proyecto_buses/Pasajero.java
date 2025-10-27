package proyecto_buses;

public class Pasajero extends Persona{
    private Boleto boleto = null;
    private String tipo;
    
    public Pasajero(String nombre, String cedula, Boleto boleto, String tipo) {
        super(nombre, cedula);
        this.boleto = boleto;
        this.tipo = tipo;
    }
    
    public Pasajero(){
        super();
        
    }
    
    public Boleto getBoleto(){
        return boleto;
    }
    public void setBoleto(Boleto boleto){
        this.boleto = boleto;
    }
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
}
