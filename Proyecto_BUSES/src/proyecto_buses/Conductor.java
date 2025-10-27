package proyecto_buses;
import java.util.Scanner;

public class Conductor extends Persona{
    private Ruta ruta = null;
    private String tipoLicencia;
    private int experienciaAños;
    
    public Conductor(String nombre, String cedula, Ruta ruta, String tipoLicencia, int experienciaAños){
        super(nombre,cedula);
        this.ruta = ruta;
        this.tipoLicencia = tipoLicencia;
        this.experienciaAños = experienciaAños;
    }
    
    public Conductor(){
        super();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de licencia del conductor: ");
        this.tipoLicencia = sc.nextLine();
        System.out.println("Ingrese los años de experiencia del conductor: ");
        String exp = sc.nextLine();
        this.experienciaAños = Integer.parseInt(exp);
    }
    
    public Ruta getRuta(){
        return ruta;
    }
    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
    
    public String getTipoLicencia(){
        return tipoLicencia;
    }
    public void setTipoLicencia(String tipoLicencia){
        this.tipoLicencia = tipoLicencia;
    }
    
    public int getExperienciaAños(){
        return experienciaAños;
    }
    public void setExperienciaAños(int experienciaAños){
        this.experienciaAños = experienciaAños;
    }
    
    public String listar(){
        return super.toString() + " (licencia " + this.tipoLicencia + ", " + this.experienciaAños + " años de experiencia)";
    }
    
}
