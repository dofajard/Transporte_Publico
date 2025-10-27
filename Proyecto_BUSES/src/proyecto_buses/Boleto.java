
package proyecto_buses;

import java.time.LocalDate;

public class Boleto {
    private Ruta ruta = null;
    private Pasajero pasajero = null;
    private double precio;
    private LocalDate fechaCompra;
    
    public Boleto(Ruta ruta, Pasajero pasajero, double precio, LocalDate fechaCompra){
        this.ruta = ruta;
        this.pasajero = pasajero;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
    }
    
    public Ruta getRuta(){
        return ruta;
    }
    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }
    
    public Pasajero getPasajero (){
        return pasajero;
    }
    public void setPasajero(Pasajero pasajero){
        this.pasajero = pasajero;
    }
    
    public LocalDate getFechaCompra(){
        return fechaCompra;
    }
    public void setFechaCompra(LocalDate fechaCompra){
        this.fechaCompra = fechaCompra;
    }
}
