package Clases;

import javax.swing.*;
import java.util.ArrayList;

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
        return tipo + " x" + cantidad + " @ $" + precio + " = $" + getSubtotal();
    }

    public static void AgregarServicios(Factura factura) {
        boolean agregarMas = true;
        while (agregarMas) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "¿Desea agregar un servicio?\n" +
                            "1. Room Service\n" +
                            "2. Restaurante\n" +
                            "3. Piscina\n" +
                            "4. Gimnasio\n" +
                            "5. Otro\n" +
                            "6. No agregar más"));

            if (opcion == 6) {
                agregarMas = false;
            } else {
                String tipoServicio;
                switch (opcion) {
                    case 1 -> tipoServicio = "Room Service";
                    case 2 -> tipoServicio = "Restaurante";
                    case 3 -> tipoServicio = "Piscina";
                    case 4 -> tipoServicio = "Gimnasio";
                    default -> tipoServicio = JOptionPane.showInputDialog("Nombre del servicio:");
                }

                double precio   = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:"));
                int    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                int idServicio = factura.getServicios().size() + 1;
                Servicio servicio = new Servicio(idServicio, tipoServicio, precio, cantidad);
                factura.agregarServicio(servicio);
                JOptionPane.showMessageDialog(null, "Servicio agregado: " + servicio.toString());
            }
        }
    }

    public static void AgregarServicios(ArrayList<Factura> facturasActivas) {
        if (facturasActivas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay facturas activas para agregar servicios.");
            return;
        }

        StringBuilder sb = new StringBuilder("Facturas activas:\n\n");
        for (Factura f : facturasActivas) {
            sb.append(f.getIdFactura()).append(" - ")
                    .append(f.getReserva().getHuesped().getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());

        int idFactura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la factura:"));
        Factura factura = null;
        for (Factura f : facturasActivas) {
            if (f.getIdFactura() == idFactura) {
                factura = f;
                break;
            }
        }
        if (factura == null) {
            JOptionPane.showMessageDialog(null, "Factura no encontrada.");
            return;
        }
        AgregarServicios(factura);
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
