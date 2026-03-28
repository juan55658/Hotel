package Clases;

public class Servicio {

    private int idServicio;
    private String tipo;
    private double precio;
    private int cantidad;

    public Servicio(int idServicio, String tipo, double precio, int cantidad) {
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return tipo;
    }

    public double getSubtotal() {
        return precio * cantidad;
    }

    public int getIdServicio(){ return idServicio; }
    public String getTipo(){ return tipo; }
    public double getPrecio(){ return precio; }
    public int getCantidad(){ return cantidad; }

    public void setIdServicio(int idServicio){ this.idServicio = idServicio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPrecio(double precio){ this.precio = precio; }
    public void setCantidad(int cantidad){ this.cantidad = cantidad; }


}
