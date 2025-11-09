package proyecto_buses_final;

public class Pasajero extends Persona{
    private Boleto boleto = null;
    private String tipo;
    
    public Pasajero(String nombre, String cedula, Boleto boleto, String tipo) {
        super(nombre, cedula);
        this.boleto = boleto;
        setTipo(tipo);
    }
    
    public Pasajero(){
        super();
        this.tipo = "Frecuente";
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
        if (tipo == null || tipo.isBlank()){
            this.tipo = "Frecuente";
            return;
        }
        this.tipo = tipo;
    }
}
