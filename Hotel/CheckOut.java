package Hotel;

import Clases.Factura;
import Clases.Servicio;

import javax.swing.*;
import java.util.ArrayList;

public class CheckOut {
    //CheckOut
    public static void CheckOutAhora(ArrayList<Factura> facturasActivas) {
        if (facturasActivas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay check-ins activos.");
            return;
        }

        // Mostrar facturas activas
        StringBuilder sb = new StringBuilder("Check-ins activos:\n\n");
        for (Factura f : facturasActivas) {
            sb.append("Reserva #").append(f.getIdFactura())
                    .append(" - ").append(f.getReserva().getHuesped().getNombre()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());

        // Pedir ID de reserva y la buscamos
        int idReserva = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el ID de la reserva para hacer Check-out:"));
        Factura factura = null;
        for (Factura f : facturasActivas) {
            if (f.getIdFactura() == idReserva) { factura = f; break; }
        }
        if (factura == null) {
            JOptionPane.showMessageDialog(null, "No hay check-in activo para esa reserva.");
            return;
        }

        if (JOptionPane.showConfirmDialog(null,
                "¿Desea agregar servicios antes de generar la factura?",
                "Agregar servicios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Servicio.AgregarServicios(factura);
        }

        // Liberar habitación
        factura.getReserva().getHabitacion().setDisponible(true);

        // Mostrar factura final
        StringBuilder facturaSb = new StringBuilder();
        facturaSb.append("======== FACTURA ========\n");
        facturaSb.append("Fecha      : ").append(factura.getFechaEmision()).append("\n");
        facturaSb.append("Huésped    : ").append(factura.getReserva().getHuesped().getNombre()).append("\n");
        facturaSb.append("Documento  : ").append(factura.getReserva().getHuesped().getDocumento()).append("\n");
        facturaSb.append("Habitación : ").append(factura.getReserva().getHabitacion().getNumero())
                .append(" (").append(factura.getReserva().getHabitacion().getTipo()).append(")\n");
        facturaSb.append("Noches     : ").append(factura.calcularNoches()).append("\n");
        facturaSb.append("\n--- Servicios ---\n");

        if (factura.getServicios().isEmpty()) {
            facturaSb.append("  Ninguno\n");
        } else {
            for (Servicio s : factura.getServicios()) {
                facturaSb.append("  ").append(s.toString()).append("\n");
            }
        }

        facturaSb.append("\n-------------------------\n");
        facturaSb.append("Habitación : $").append(factura.calcularTotalHabitacion()).append("\n");
        facturaSb.append("Servicios  : $").append(factura.calcularTotalServicios()).append("\n");
        facturaSb.append("TOTAL      : $").append(factura.calcularTotalFinal()).append("\n");

        facturaSb.append("=========================");

        JOptionPane.showMessageDialog(null, facturaSb.toString(), "Factura Final",
                JOptionPane.INFORMATION_MESSAGE);

        // Eliminar factura activa
        facturasActivas.remove(factura);
    }
}
