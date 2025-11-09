package proyecto_buses_final;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private String cedula;
    
    public Persona(String nombre, String cedula){
        setNombre(nombre);
        setCedula(cedula);
    }
    
    public Persona(){
        Scanner sc = new Scanner(System.in);
        
        String n = "";
        do {
            System.out.print("Ingrese el nombre (solo letras, espacios o guion): ");
            n = sc.nextLine();
        } while (n == null || n.isBlank() || !n.matches("[A-Za-zÑñ -]+"));
        this.nombre = n;
        
        String c = "";
        do {
            System.out.print("Ingrese la cedula (10 digitos): ");
            c = sc.nextLine();
        } while (c == null || !c.matches("\\d{10}"));
        this.cedula = c;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        if (nombre == null || nombre.isBlank() || !nombre.matches("[A-Za-zÑñ -]+")){
            System.out.println("Nombre invalido.");
            return;
        }
        this.nombre = nombre;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public void setCedula(String cedula){
        if (cedula == null || !cedula.matches("\\d{10}")){
            System.out.println("Cedula invalida.");
            return;
        }
        this.cedula = cedula;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
