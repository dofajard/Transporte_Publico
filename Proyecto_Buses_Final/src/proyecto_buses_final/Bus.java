package proyecto_buses_final;
import java.util.Scanner;

public class Bus implements Reservable {
    private int capacidadMaxima = 20;
    private Ruta ruta = null;
    private String placa;
    private int nPasajeros;
    
    public Bus(int capacidadMaxima, Ruta ruta, String placa, int nPasajeros){
        setCapacidadMaxima(capacidadMaxima);
        this.ruta = ruta;
        setPlaca(placa);
        setNPasajeros(nPasajeros);
    }
    
    public Bus(){
        Scanner sc = new Scanner(System.in);
        
        Integer cap = null;
        do {
            System.out.print("Ingrese la capacidad del bus (>0): ");
            String s = sc.nextLine();
            try {
                int v = Integer.parseInt(s);
                if (v > 0){
                    cap = v;
                } else {
                    System.out.println("Debe ser mayor que 0.");
                }
            } catch (NumberFormatException e){
                System.out.println("Ingrese un numero entero valido.");
            }
        } while (cap == null);
        this.capacidadMaxima = cap;
        
        String pl = "";
        do {
            System.out.print("Ingrese placa del bus (ABC-1234): ");
            pl = sc.nextLine();
        } while (pl == null || pl.isBlank() || !pl.toUpperCase().matches("[A-Z]{3}-\\d{3,4}"));
        this.placa = pl.toUpperCase();
        
        this.nPasajeros = 0;
    }
    
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    
    public void setCapacidadMaxima(int capacidadMaxima){
        if (capacidadMaxima <= 0){
            System.out.println("Capacidad invalida.");
            return;
        }
        if (this.nPasajeros > capacidadMaxima){
            this.nPasajeros = capacidadMaxima;
        }
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
        if (placa == null || placa.isBlank()){
            System.out.println("Placa invalida.");
            return;
        }
        String p = placa.toUpperCase();
        if (!p.matches("[A-Z]{3}-\\d{3,4}")){
            System.out.println("Placa invalida (formato ABC-1234).");
            return;
        }
        this.placa = p;
    }
    
    public int getNPasajeros(){
        return nPasajeros;
    }
    
    public void setNPasajeros(int nPasajeros){
        if (nPasajeros < 0){
            System.out.println("Cantidad de pasajeros invalida.");
            return;
        }
        if (nPasajeros > this.capacidadMaxima){
            System.out.println("No puede exceder la capacidad del bus.");
            return;
        }
        this.nPasajeros = nPasajeros;
    }
    
    public String listar(){
        return this.toString() + " (capacidad " + this.capacidadMaxima + ")";
    }

    @Override
    public String toString(){
        return this.placa;
    }
    
    @Override
    public boolean verificarCapacidad(){
        return this.nPasajeros < this.capacidadMaxima;
    }
}
