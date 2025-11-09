package proyecto_buses_final;
import java.util.Scanner;

public class Conductor extends Persona{
    private Ruta ruta = null;
    private String tipoLicencia;
    private int experienciaAños;
    
    public Conductor(String nombre, String cedula, Ruta ruta, String tipoLicencia, int experienciaAños){
        super(nombre,cedula);
        this.ruta = ruta;
        setTipoLicencia(tipoLicencia);
        setExperienciaAños(experienciaAños);
    }
    
    public Conductor(){
        super();
        Scanner sc = new Scanner(System.in);
        
        String tl = "";
        do {
            System.out.print("Ingrese el tipo de licencia del conductor (A/B/C): ");
            tl = sc.nextLine();
        } while (tl == null || tl.isBlank() || !"ABC".contains(tl.toUpperCase()));
        this.tipoLicencia = tl.toUpperCase();
        
        Integer exp = null;
        do {
            System.out.print("Ingrese los años de experiencia del conductor (>=0): ");
            String e = sc.nextLine();
            try {
                int v = Integer.parseInt(e);
                if (v >= 0){
                    exp = v;
                } else {
                    System.out.println("Debe ser mayor o igual a 0.");
                }
            } catch (NumberFormatException ex){
                System.out.println("Ingrese un numero entero valido.");
            }
        } while (exp == null);
        this.experienciaAños = exp;
    }
    
    public Ruta getRuta(){
        return ruta;
    }
    
    public void setRuta(Ruta ruta){
        if (this.ruta != null){
            System.out.println("El chofer ya tiene una ruta asignada.");
            return;
        }
        this.ruta = ruta;
    }
    
    public String getTipoLicencia(){
        return tipoLicencia;
    }
    
    public void setTipoLicencia(String tipoLicencia){
        if (tipoLicencia == null){
            System.out.println("Licencia invalida.");
            return;
        }
        String t = tipoLicencia.toUpperCase();
        if (!"ABC".contains(t)){
            System.out.println("Licencia invalida (A/B/C).");
            return;
        }
        this.tipoLicencia = t;
    }
    
    public int getExperienciaAños(){
        return experienciaAños;
    }
    
    public void setExperienciaAños(int experienciaAños){
        if (experienciaAños < 0){
            System.out.println("La experiencia no puede ser negativa.");
            return;
        }
        this.experienciaAños = experienciaAños;
    }
    
    public String listar(){
        return super.toString() + " (licencia " + this.tipoLicencia + ", " + this.experienciaAños + " años de experiencia)";
    }
}
