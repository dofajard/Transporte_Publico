package proyecto_buses;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private String cedula;
    
    public Persona(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }
    public Persona(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        this.nombre = sc.nextLine();
        System.out.print("Ingrese la cedula: ");
        this.cedula = sc.nextLine();
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
