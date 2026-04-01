package Hotel;

import Clases.Factura;
import Clases.Reserva;

import javax.swing.*;
import java.util.ArrayList;

public class CkeckIn {
    //CheckIn
    public static void CheckInAhora(ArrayList<Reserva> reservas, ArrayList<Factura> facturasActivas) {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas.");
            return;
        }

        // Mostrar reservas disponibles
        StringBuilder sb = new StringBuilder("Reservas disponibles:\n\n");
        for (Reserva r : reservas) {
            sb.append(r.getIdReserva()).append(" - ")
                    .append(r.getHuesped().getNombre()).append(" | Hab. ")
                    .append(r.getHabitacion().getNumero()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());

        // Pedir ID de reserva
        int idReserva = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese el ID de la reserva para hacer Check-in:"));

        // Buscar la reserva
        Reserva reserva = null;
        for (Reserva r : reservas) {
            if (r.getIdReserva() == idReserva) {
                reserva = r;
                break;
            }
        }
        if (reserva == null) {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
            return;
        }

        // Verificar que la habitación esté disponible
        if (!reserva.getHabitacion().getDisponible()) {
            JOptionPane.showMessageDialog(null, "Esta reserva ya tiene check-in activo.");
            return;
        }

        // Marcar habitación como ocupada y crear factura vacía
        reserva.getHabitacion().setDisponible(false);
        Factura factura = new Factura(idReserva, reserva);
        facturasActivas.add(factura);

        JOptionPane.showMessageDialog(null,
                "Check-in exitoso.\n" +
                        "Huésped: " + reserva.getHuesped().getNombre() + "\n" +
                        "Habitación " + reserva.getHabitacion().getNumero() + " ahora ocupada.");

    }
}