package proyecto_buses_final;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

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
        Ruta r3 = new Ruta(50, true, "Guayaquil", "Montanita, Ballenita", "Esmeraldas");
        Ruta r4 = new Ruta(80, true, "Guayaquil", "Duran, Yaguachi", "Cuenca");
        listaRutas.add(r1);
        listaRutas.add(r2);
        listaRutas.add(r3);
        listaRutas.add(r4);
        
        Conductor c1 = new Conductor("Leonel Ponce", "0961111111", r1, "C", 4);
        Conductor c2 = new Conductor("Cesar Barberan", "0962222222", r2, "A", 10);
        Conductor c3 = new Conductor("Fernando Ayala", "0962222223", r3, "B", 7);
        Conductor c4 = new Conductor("Maicol Geampier", "0962222224", r4, "C", 9);
        listaConductores.add(c1);
        listaConductores.add(c2);
        listaConductores.add(c3);
        listaConductores.add(c4);
        
        Bus b1 = new Bus(20, r1, "GTL-8276", 1);
        Bus b2 = new Bus(20, r2, "KTL-9276", 1);
        Bus b3 = new Bus(20, r3, "GPL-8676", 1);
        Bus b4 = new Bus(20, r4, "GTV-8256", 1);
        listaBuses.add(b1);
        listaBuses.add(b2);
        listaBuses.add(b3);
        listaBuses.add(b4);

        Pasajero p1 = new Pasajero("Ana Lopez", "0961111111", null, "Frecuente");
        Pasajero p2 = new Pasajero("Mario Garcia", "0962222222", null, "Eventual");
        listaPasajeros.add(p1);
        listaPasajeros.add(p2);
        
        Boleto t1 = new Boleto(r1, p1, 2.50, LocalDate.now());
        Boleto t2 = new Boleto(r2, p2, 3.00, LocalDate.now());
        listaBoletos.add(t1);
        listaBoletos.add(t2);
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

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public ArrayList<Bus> getListaBuses(){
        return listaBuses;
    }
    
    public void setListaBuses(ArrayList<Bus> listaBuses){
        this.listaBuses = listaBuses;
    }

    public ArrayList<Conductor> getListaConductores(){
        return listaConductores;
    }
    
    public void setListaConductores(ArrayList<Conductor> listaConductores){
        this.listaConductores = listaConductores;
    }

    public ArrayList<Pasajero> getListaPasajeros(){
        return listaPasajeros;
    }
    
    public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros){
        this.listaPasajeros = listaPasajeros;
    }

    public ArrayList<Ruta> getListaRutas(){
        return listaRutas;
    }
    
    public void setListaRutas(ArrayList<Ruta> listaRutas){
        this.listaRutas = listaRutas;
    }

    public ArrayList<Boleto> getListaBoletos(){
        return listaBoletos;
    }
    
    public void setListaBoletos(ArrayList<Boleto> listaBoletos){
        this.listaBoletos = listaBoletos;
    }
    
    private int pedirIndiceValido(Scanner sc, int max, String mensaje){
        int idx = -1;
        do {
            System.out.print(mensaje);
            String s = sc.nextLine();
            try {
                idx = Integer.parseInt(s) - 1;
            } catch (NumberFormatException e){
                idx = -1;
            }
        } while (idx < 0 || idx >= max);
        return idx;
    }

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
        System.out.println("Bus con placa " + b + " ha sido registrado con exito");
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
        
        if (this.listaRutas.isEmpty()){
            System.out.println("No hay rutas.");
            return;
        }
        
        System.out.println("Seleccione la ruta a asignar");
        for(int i=0;i < this.listaRutas.size(); i++){
            int contador = i + 1;
            System.out.println(contador + " " + this.listaRutas.get(i).listar());
        }
        int rutaSelect = pedirIndiceValido(sc, this.listaRutas.size(), "Ingrese opcion: ");
        
        System.out.println("Seleccione un conductor");
        ArrayList<Integer> disponibles = new ArrayList<>();
        for(int i=0;i < this.listaConductores.size(); i++){
            int contador = i + 1;
            if(this.listaConductores.get(i).getRuta() == null){
                disponibles.add(i);
                System.out.println(contador + " " + this.listaConductores.get(i).listar());
            }
        }
        if (disponibles.isEmpty()){
            System.out.println("No hay conductores disponibles.");
            return;
        }
        int conductorSeleccionado = pedirIndiceValido(sc, this.listaConductores.size(), "Ingrese opcion: ");
        if(this.listaConductores.get(conductorSeleccionado).getRuta() != null){
            System.out.println("El chofer ya tiene una ruta asignada.");
            return;
        }
        this.listaConductores.get(conductorSeleccionado).setRuta(this.listaRutas.get(rutaSelect));
        
        System.out.println("Seleccione un bus");
        ArrayList<Integer> busesLibres = new ArrayList<>();
        for(int i=0;i < this.listaBuses.size(); i++){
            int contador = i + 1;
            if(this.listaBuses.get(i).getRuta() == null){
                busesLibres.add(i);
                System.out.println(contador + " " + this.listaBuses.get(i).listar());
            }
        }
        if (busesLibres.isEmpty()){
            System.out.println("No hay buses disponibles.");
            return;
        }
        int busSeleccionado = pedirIndiceValido(sc, this.listaBuses.size(), "Ingrese opcion: ");
        this.listaBuses.get(busSeleccionado).setRuta(this.listaRutas.get(rutaSelect));
        System.out.println("se ha asigando bus y conductor a la ruta");
    }
        
    public void menuListarRutaDisponible(){
        System.out.println("listar ruta disponible");
        for(int i = 0; i < this.listaRutas.size(); i++){
            int contador = i + 1;
            System.out.println(contador + " " + "Ruta " + this.listaRutas.get(i).listar());
        }
    }
    
    public void menuRegistrarVentaBoleto(){
        System.out.println("registrar venta de boletos");
        Scanner sc = new Scanner(System.in);
        
        if (this.listaRutas.isEmpty()){
            System.out.println("No hay rutas.");
            return;
        }
        
        System.out.println("Seleccione la ruta");
        for(int i=0;i < this.listaRutas.size(); i++){
            int contador = i + 1;
            System.out.println(contador + " " + this.listaRutas.get(i).listar());
        }
        int rutaSelect = pedirIndiceValido(sc, this.listaRutas.size(), "Seleccione ruta: ");
        Ruta rutaElegida = this.listaRutas.get(rutaSelect);
        
        Bus busRuta = null;
        for(int i=0;i < this.listaBuses.size(); i++){
            if(this.listaBuses.get(i).getRuta() == rutaElegida){
                busRuta = this.listaBuses.get(i);
            }
        }
        if (busRuta == null){
            System.out.println("No se puede operar: la ruta no tiene bus asignado.");
            return;
        }
        if(!busRuta.verificarCapacidad()){
            System.out.println("No hay capacidad disponible.");
            return;
        }
        
        if (this.listaPasajeros.isEmpty()){
            System.out.println("No hay pasajeros registrados.");
            return;
        }
        for(int i=0;i < this.listaPasajeros.size(); i++){
            int contador = i + 1;
            System.out.println(contador + " Pasajero: " + this.listaPasajeros.get(i));
        }
        int pasajeroSelect = pedirIndiceValido(sc, this.listaPasajeros.size(), "Seleccione un pasajero: ");
        Pasajero pasajeroElegido = this.listaPasajeros.get(pasajeroSelect);
        
        for (int j = 0; j < this.listaBoletos.size(); j++){
            Boleto bx = this.listaBoletos.get(j);
            if (bx.getRuta() == rutaElegida && bx.getPasajero() == pasajeroElegido){
                System.out.println("Ya existe un boleto para ese pasajero en esa ruta.");
                return;
            }
        }
        
        Boleto t0 = new Boleto();
        double total = t0.calcularPrecio(rutaElegida);
        System.out.println("Valor total a pagar: " + total);
        System.out.print("Desea realizar la compra?? (s/n): ");
        String opcion = sc.nextLine().toLowerCase();
        if("s".equals(opcion)){
            t0.setRuta(rutaElegida);
            t0.setPasajero(pasajeroElegido);
            t0.setPrecio(total);
            t0.setFechaCompra(LocalDate.now());
            listaBoletos.add(t0);
            busRuta.setNPasajeros(busRuta.getNPasajeros() + 1);
            System.out.print("Venta registrada con exito!");
        }else{
            System.out.println("Venta cancelada.");
        }
    }
    
    public void menuMostrarBoletos(){
        System.out.println("mostrar boletos");
        for(int i = 0; i < this.listaRutas.size(); i++){
            System.out.print(this.listaRutas.get(i) + " boletos vendidos: ");
            int suma = 0;
            for(int j = 0; j < this.listaBoletos.size(); j++){
                if(this.listaBoletos.get(j).getRuta() == this.listaRutas.get(i)){
                    suma += 1;
                }
            }
            System.out.println(suma);
        }
    }
    
    public void menuConsultarIngresos(){
        System.out.println("Consultar ingresos totales por dia");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la fecha (AAAA-MM-DD): ");
        String fechaTexto = sc.nextLine();
        LocalDate fechaBuscada;
        try {
            fechaBuscada = LocalDate.parse(fechaTexto);
        } catch (Exception e){
            System.out.println("Fecha invalida.");
            return;
        }

        double totalDia = 0.0;

        System.out.println("Detalle por ruta en la fecha " + fechaBuscada + ":");

        for (int i = 0; i < this.listaRutas.size(); i++) {
            Ruta rutaActual = this.listaRutas.get(i);
            double totalRuta = 0.0;

            for (int j = 0; j < this.listaBoletos.size(); j++) {
                Boleto boletoActual = this.listaBoletos.get(j);
                if (boletoActual.getRuta() == rutaActual && boletoActual.getFechaCompra().equals(fechaBuscada)) {
                    totalRuta = totalRuta + boletoActual.getPrecio();
                }
            }

            System.out.println("Ruta " + rutaActual.listar() + " $" + totalRuta);
            totalDia = totalDia + totalRuta;
        }

        System.out.println("TOTAL vendido en " + fechaBuscada + ": $" + totalDia);
    }
    
    public void menuReporte(){
        System.out.println("Reporte: rutas mas usadas");

        int[] contadorPorRuta = new int[this.listaRutas.size()];

        for (int i = 0; i < this.listaRutas.size(); i++) {
            Ruta rutaActual = this.listaRutas.get(i);
            int suma = 0;

            for (int j = 0; j < this.listaBoletos.size(); j++) {
                Boleto boletoActual = this.listaBoletos.get(j);
                if (boletoActual.getRuta() == rutaActual) {
                    suma = suma + 1;
                }
            }

            contadorPorRuta[i] = suma;
        }

        System.out.println("Boletos vendidos por ruta:");
        for (int i = 0; i < this.listaRutas.size(); i++) {
            System.out.println(this.listaRutas.get(i).listar() + " -> " + contadorPorRuta[i] + " boletos");
        }

        int indiceMax = 0;
        for (int i = 1; i < contadorPorRuta.length; i++) {
            if (contadorPorRuta[i] > contadorPorRuta[indiceMax]) {
                indiceMax = i;
            }
        }

        System.out.println("Ruta mas usada: " + this.listaRutas.get(indiceMax).listar() +
                        " con " + contadorPorRuta[indiceMax] + " boletos vendidos.");
    }
    
    public void menuListar(){
        System.out.println("Buses disponibles (sin ruta asignada):");
        for (int i = 0; i < this.listaBuses.size(); i++) {
            int contador = i + 1;
            if (this.listaBuses.get(i).getRuta() == null) {
                System.out.println(contador + " " + this.listaBuses.get(i).listar());
            }
        }

        System.out.println("Conductores disponibles (sin ruta asignada):");
        for (int i = 0; i < this.listaConductores.size(); i++) {
            int contador = i + 1;
            if (this.listaConductores.get(i).getRuta() == null) {
                System.out.println(contador + " " + this.listaConductores.get(i).listar());
            }
        }
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
        } while(!"l".equals(ops));
    }
}

