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

// Menu de pagos
        boolean pagado = false;
        while (!pagado) {
            int metodoPago = Integer.parseInt(JOptionPane.showInputDialog(
                    "Total a pagar: $" + factura.calcularTotalFinal() +
                            "\n\nSeleccione método de pago:" +
                            "\n 1. Efectivo" +
                            "\n 2. Tarjeta de crédito/débito" +
                            "\n 3. Cancelar (volver)"));

            switch (metodoPago) {
                case 1 -> {
                    double montoEntregado = Double.parseDouble(
                            JOptionPane.showInputDialog("Ingrese el monto entregado: $"));

                    if (montoEntregado < factura.calcularTotalFinal()) {
                        JOptionPane.showMessageDialog(null,
                                "Monto insuficiente. Faltan: $" +
                                        (factura.calcularTotalFinal() - montoEntregado));
                    } else {
                        double cambio = montoEntregado - factura.calcularTotalFinal();
                        JOptionPane.showMessageDialog(null,
                                "✔ Pago en efectivo exitoso.\n" +
                                        "Monto entregado: $" + montoEntregado + "\n" +
                                        "Cambio          : $" + cambio);
                        pagado = true;
                    }
                }
                case 2 -> {
                    String numeroTarjeta = JOptionPane.showInputDialog("Ingrese el número de tarjeta (16 dígitos):");
                    if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
                        JOptionPane.showMessageDialog(null, "Número de tarjeta inválido.");
                        break;
                    }
                    String nombreTarjeta = JOptionPane.showInputDialog("Nombre en la tarjeta:");
                    String vencimiento   = JOptionPane.showInputDialog("Fecha de vencimiento (MM/AA):");
                    String cvv           = JOptionPane.showInputDialog("CVV:");

                    if (nombreTarjeta == null || vencimiento == null || cvv == null ||
                            nombreTarjeta.isEmpty() || vencimiento.isEmpty() || cvv.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Datos de tarjeta incompletos.");
                        break;
                    }

                    JOptionPane.showMessageDialog(null,
                            "✔ Pago con tarjeta exitoso.\n" +
                                    "Tarjeta: **** **** **** " + numeroTarjeta.substring(12) + "\n" +
                                    "Monto cobrado: $" + factura.calcularTotalFinal());
                    pagado = true;
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Pago cancelado. La factura sigue activa.");
                    return; // sale sin eliminar la factura
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }

    // Solo se elimina si se pagó
        factura.getReserva().getHabitacion().setDisponible(true);
        facturasActivas.remove(factura);
        JOptionPane.showMessageDialog(null, "Check-out completado. Habitación liberada.");
    }
}
