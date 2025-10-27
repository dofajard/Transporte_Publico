package proyecto_buses;

import java.util.ArrayList;
import java.util.Scanner;

public class Cooperativa {
    private String nombre;
    private ArrayList<Bus> listaBuses;
    private ArrayList<Conductor> listaConductores;
    private ArrayList<Pasajero> listaPasajeros;
    private ArrayList<Ruta> listaRutas;
    private ArrayList<Boleto> listaBoletos;

    public Cooperativa(){
        this.nombre = "";
        this.listaBuses = new ArrayList<>();
        this.listaConductores = new ArrayList<>();
        this.listaPasajeros = new ArrayList<>();
        this.listaRutas = new ArrayList<>();
        this.listaBoletos = new ArrayList<>();
        
        Ruta r1 = new Ruta(150, true, "Guayaquil", "Daule, Milagro", "Quito");
        Ruta r2 = new Ruta(75, true, "Guayaquil", "Milagro, Tura", "Machala");
        Ruta r3 = new Ruta(50, true, "Guayaquil", "Montañita, ballenita", "Esmeraldas");
        Ruta r4 = new Ruta(80, true, "Guayaquil", "Duran, Yaguachi", "Cuenca");
        listaRutas.add(r1);
        listaRutas.add(r2);
        listaRutas.add(r3);
        listaRutas.add(r4);
        
        Conductor c1 = new Conductor("Leonel Ponce", "09127263128",null , "C", 4);
        Conductor c2 = new Conductor("Cesar Barberan", "09127238458",null , "A", 10);
        Conductor c3 = new Conductor("Fernando Ayala", "09127295478",null , "B", 7);
        Conductor c4 = new Conductor("Maicol Geampier", "09127269476",null , "C", 9);
        listaConductores.add(c1);
        listaConductores.add(c2);
        listaConductores.add(c3);
        listaConductores.add(c4);
        
        Bus b1 = new Bus(20, null, "GTL-8276");
        Bus b2 = new Bus(20, null, "KTL-9276");
        Bus b3 = new Bus(20, null, "GPL-8676");
        Bus b4 = new Bus(20, null, "GTV-8256");
        listaBuses.add(b1);
        listaBuses.add(b2);
        listaBuses.add(b3);
        listaBuses.add(b4);

        Pasajero p1 = new Pasajero("Jorge Jacome", "0965786528", null, "Frecuente");
        Pasajero p2 = new Pasajero("Bianca Viera", "0965876428", null, "Frecuente");
        Pasajero p3 = new Pasajero("Lily Freire", "0947638764", null, "Frecuente");
        Pasajero p4 = new Pasajero("Luis Campoverde", "0973549876", null, "Frecuente");
        listaPasajeros.add(p1);
        listaPasajeros.add(p2);
        listaPasajeros.add(p3);
        listaPasajeros.add(p4);




    }

    public Cooperativa(String nombre,
                       ArrayList<Bus> listaBuses,
                       ArrayList<Conductor> listaConductores,
                       ArrayList<Pasajero> listaPasajeros,
                       ArrayList<Ruta> listaRutas,
                       ArrayList<Boleto> listaBoletos) {
        this.nombre = nombre;
        this.listaBuses = (listaBuses != null) ? listaBuses : new ArrayList<>();
        this.listaConductores = (listaConductores != null) ? listaConductores : new ArrayList<>();
        this.listaPasajeros = (listaPasajeros != null) ? listaPasajeros : new ArrayList<>();
        this.listaRutas = (listaRutas != null) ? listaRutas : new ArrayList<>();
        this.listaBoletos = (listaBoletos != null) ? listaBoletos : new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ArrayList<Bus> getListaBuses() { return listaBuses; }
    public void setListaBuses(ArrayList<Bus> listaBuses) { this.listaBuses = listaBuses; }

    public ArrayList<Conductor> getListaConductores() { return listaConductores; }
    public void setListaConductores(ArrayList<Conductor> listaConductores) { this.listaConductores = listaConductores; }

    public ArrayList<Pasajero> getListaPasajeros() { return listaPasajeros; }
    public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) { this.listaPasajeros = listaPasajeros; }

    public ArrayList<Ruta> getListaRutas() { return listaRutas; }
    public void setListaRutas(ArrayList<Ruta> listaRutas) { this.listaRutas = listaRutas; }

    public ArrayList<Boleto> getListaBoletos() { return listaBoletos; }
    public void setListaBoletos(ArrayList<Boleto> listaBoletos) { this.listaBoletos = listaBoletos; }
    
    
    public void menuRegistrarConductor(){
        System.out.println("Registrar conductor");
        Conductor c = new Conductor();
        this.listaConductores.add(c);
        System.out.println("Conductor " + c + " registrado con exito.");
    }
    
    public void menuRegistrarPasajero(){
        System.out.println("Registrar pasajero");
        Pasajero p = new Pasajero();
        this.listaPasajeros.add(p);
        System.out.println("Pasajero " + p + " registrado con exito.");
        
    }
    
    public void menuBus(){
        System.out.println("Registrar bus");
        Bus b = new Bus();
        this.listaBuses.add(b);
        System.out.println("Bus con placa " + b + " a sido registrado con exito");
    }
    
    public void menuCrearRuta(){
        System.out.println("crear ruta");
        Ruta r = new Ruta();
        this.listaRutas.add(r);
        System.out.println("Ruta " + r + " creada con exito");
    }
    
    public void menuAsignarConductor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("asignar conductor");
        System.out.println("Seleccione la ruta a asignar");
        for(int i=0;i <this.listaRutas.size(); i++){
            int contador = i + 1;
            System.out.println(contador + " " + this.listaRutas.get(i).listar());
        }
        String opcion = sc.nextLine();
        int rutaSelect = Integer.parseInt(opcion);
        System.out.println("Seleccione un conductor");
        for(int i=0;i < this.listaConductores.size(); i++){
            int contador = i + 1;
            if(this.listaConductores.get(i).getRuta() == null){
                System.out.println(contador + " " + this.listaConductores.get(i).listar());
            }
        }
        opcion = sc.nextLine();
        int conductorSeleccionado = Integer.parseInt(opcion);
        this.listaConductores.get(conductorSeleccionado).setRuta(this.listaRutas.get(rutaSelect));
        ///////
        System.out.println("Seleccione un bus");
        for(int i=0;i < this.listaBuses.size(); i++){
            int contador = i + 1;
            if(this.listaBuses.get(i).getRuta() == null){
                System.out.println(contador + " " + this.listaBuses.get(i).listar());
            }
        }
        opcion = sc.nextLine();
        int busSeleccionado = Integer.parseInt(opcion);
        this.listaBuses.get(busSeleccionado).setRuta(this.listaRutas.get(rutaSelect));
        System.out.println("se ha asigando bus y conductor a la ruta");
        
        
    }
    
    public void menuListarRutaDisponible(){
        System.out.println("listar ruta disponible");
    }
    
    public void menuRegistrarVentaBoleto(){
        System.out.println("registrar venta de boletos");
    }
    
    public void menuMostrarBoletos(){
        System.out.println("mostrar boletos");
    }
    
    public void menuConsultarIngresos(){
        System.out.println("Consultar ingresos");
    }
    
    public void menuReporte(){
        System.out.println("mostrar reporte");
    }
    
    public void menuListar(){
        System.out.println("listar");
    }
    
    public void menu(){
        
        Scanner sc = new Scanner(System.in);
        String ops = "";
        String showMenu = "Bienvenido!!" + "\n" +
                "Elija una opcion para continua" + "\n" +
                "a. Registrar conductor" + "\n" +
                "b. Registrar pasajero" + "\n" +
                "c. Registrar bus" + "\n" +
                "d. Crear ruta con paradas intermedias" + "\n" + 
                "e. Asignar conductor y bus a ruta" + "\n" + 
                "f. Listar rutas disponibles" + "\n" +
                "g. Registrar venta de boleto" + "\n" +
                "h. Mostrar vendidos por ruta" + "\n" +
                "i. Consultar ingresos totales por dia" + "\n" +
                "j. Reporte: rutas mas usadas" + "\n" +
                "k. Listar buses y conductores disponibles" + "\n" +
                "l. Salir" + "\n" + "Ingrese su opcion aqui: ";
        do{
            System.out.print(showMenu);
            ops = sc.nextLine().toLowerCase();
            switch(ops){
                case "a": 
                    this.menuRegistrarConductor();
                    break;
                case "b":
                    this.menuRegistrarPasajero();
                    break;
                case "c":
                    this.menuBus();
                    break;
                case "d":
                    this.menuCrearRuta();
                    break;
                case "e":
                    this.menuAsignarConductor();
                    break;
                case "f":
                    this.menuListarRutaDisponible();
                    break;
                case "g":
                    this.menuRegistrarVentaBoleto();
                    break;
                case "h":
                    this.menuMostrarBoletos();
                    break;
                case "i":
                    this.menuConsultarIngresos();
                    break;
                case "j":
                    this.menuReporte();
                    break;
                case "k":
                    this.menuListar();
                    break;
                case "l":
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("La opcion seleccionada no existe");
            }
            
        }while(!"l".equals(ops));
    }
}

