package proyecto_buses;
import java.util.Scanner;

public class Bus {
    private int capacidadMaxima = 20;
    private Ruta ruta = null;
    private String placa;
    
    public Bus(int capacidadMaxima, Ruta ruta, String placa){
        this.capacidadMaxima = capacidadMaxima;
        this.ruta = ruta;
        this.placa = placa;
    }
    
    public Bus(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la capacidad del bus: ");
        String cap = sc.nextLine();
        this.capacidadMaxima = Integer.parseInt(cap);
        System.out.print("Ingrese placa del bus: ");
        this.placa = sc.nextLine();
    }
    
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public Ruta getRuta(){
        return ruta;
    }
    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
    
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public String listar(){
        return this.toString() + " (capacidad " + this.capacidadMaxima + ")";
    }

    @Override
    
    public String toString(){
        return this.placa;
    } 
}
