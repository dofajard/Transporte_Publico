package proyecto_buses_final;

import java.time.LocalDate;

public class Boleto implements Pagable {
    private Ruta ruta = null;
    private Pasajero pasajero = null;
    private double precio;
    private LocalDate fechaCompra;
    
    public Boleto(Ruta ruta, Pasajero pasajero, double precio, LocalDate fechaCompra){
        setRuta(ruta);
        setPasajero(pasajero);
        setPrecio(precio);
        setFechaCompra(fechaCompra);
    }
    
    public Boleto(){
        this.ruta = null;
        this.pasajero = null;
        this.precio = 0;
        this.fechaCompra = LocalDate.now();
    }
    
    public Ruta getRuta(){
        return ruta;
    }
    
    public void setRuta(Ruta ruta){
        if (ruta == null){
            System.out.println("Ruta invalida.");
            return;
        }
        this.ruta = ruta;
    }
    
    public Pasajero getPasajero (){
        return pasajero;
    }
    
    public void setPasajero(Pasajero pasajero){
        if (pasajero == null){
            System.out.println("Pasajero invalido.");
            return;
        }
        this.pasajero = pasajero;
    }
    
    public LocalDate getFechaCompra(){
        return fechaCompra;
    }
    
    public void setFechaCompra(LocalDate fechaCompra){
        if (fechaCompra == null){
            System.out.println("Fecha invalida. Usando hoy.");
            this.fechaCompra = LocalDate.now();
            return;
        }
        if (fechaCompra.isAfter(LocalDate.now())){
            System.out.println("La fecha no puede ser futura. Usando hoy.");
            this.fechaCompra = LocalDate.now();
            return;
        }
        this.fechaCompra = fechaCompra;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(double precio){
        if (precio < 0){
            System.out.println("Precio invalido. Usando 0.");
            this.precio = 0;
            return;
        }
        this.precio = precio;
    }
    
    @Override
    public double calcularPrecio(Ruta ruta){
        return ruta.getDistancia() * 0.20;
    }
}
