package proyecto_buses;
import java.util.Scanner;

public class Ruta {
    private int distancia;
    private boolean activa = false;
    private String origen;
    private String paradas;
    private String destino;


    public Ruta(int distancia, boolean activa,
                String origen, String paradas, String destino) {
        this.distancia = distancia;
        this.activa = activa;
        this.origen = origen;
        this.paradas = paradas;
        this.destino = destino;
    }
    
    public Ruta(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese origen: ");
        this.origen = sc.nextLine();
        System.out.print("Ingrese destino: ");
        this.destino = sc.nextLine();
        System.out.print("Ingrese las paradas (SEPARADAS POR COMA): ");
        this.paradas = sc.nextLine();
        
    }

    public int getDistancia(){
        return distancia;
    }
    public void setDistancia(int distancia){
        this.distancia = distancia;
    }

    public boolean isActiva(){
        return activa;
    }
    public void setActiva(boolean activa){
        this.activa = activa;
    }

    public String getOrigen(){
        return origen;
    }
    public void setOrigen(String origen){
        this.origen = origen;
    }

    public String getParadas(){
        return paradas;
    }
    public void setParadas(String paradas){
        this.paradas = paradas;
    }

    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public String listar(){
        return this.toString() + " Paradas: " + this.paradas;
    }
    
    @Override
    public String toString(){
        return this.origen + " - " + this.destino;
    }
    
}
