package proyecto_buses_final;
import java.util.Scanner;

public class Ruta {
    private int distancia;
    private boolean activa = false;
    private String origen;
    private String paradas;
    private String destino;

    public Ruta(int distancia, boolean activa, String origen, String paradas, String destino) {
        setDistancia(distancia);
        setActiva(activa);
        setOrigen(origen);
        setParadas(paradas);
        setDestino(destino);
        if (this.origen != null && this.destino != null && this.origen.equalsIgnoreCase(this.destino)){
            System.out.println("Origen y destino no pueden ser iguales.");
        }
    }
    
    public Ruta(){
        Scanner sc = new Scanner(System.in);
        
        String o = "";
        do {
            System.out.print("Ingrese origen: ");
            o = sc.nextLine();
        } while (o == null || o.isBlank());
        this.origen = o;
        
        String d = "";
        do {
            System.out.print("Ingrese destino (distinto a origen): ");
            d = sc.nextLine();
        } while (d == null || d.isBlank() || d.equalsIgnoreCase(this.origen));
        this.destino = d;
        
        System.out.print("Ingrese las paradas (SEPARADAS POR COMA): ");
        this.paradas = sc.nextLine();
        
        Integer dist = null;
        do {
            System.out.print("Ingrese distancia (>0): ");
            String s = sc.nextLine();
            try {
                int v = Integer.parseInt(s);
                if (v > 0){
                    dist = v;
                } else {
                    System.out.println("Debe ser mayor que 0.");
                }
            } catch (NumberFormatException e){
                System.out.println("Ingrese un numero entero valido.");
            }
        } while (dist == null);
        this.distancia = dist;
    }

    public int getDistancia(){
        return distancia;
    }
    
    public void setDistancia(int distancia){
        if (distancia <= 0){
            System.out.println("Distancia invalida.");
            return;
        }
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
        if (origen == null || origen.isBlank()){
            System.out.println("Origen invalido.");
            return;
        }
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
        if (destino == null || destino.isBlank()){
            System.out.println("Destino invalido.");
            return;
        }
        this.destino = destino;
    }
    
    @Override
    public String toString(){
        return this.origen + " - " + this.destino;
    }
    
    public String listar(){
        return this.toString() + ", Paradas: " + this.paradas + " Distancia: " + this.distancia;
    }
}
