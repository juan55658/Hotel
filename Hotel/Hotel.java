package Hotel;

import Clases.*;

import java.time.LocalDate;
import javax.swing.*;
import java.util.ArrayList;

public class Hotel {
    private final ArrayList<Huesped> huespedes;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;
    private ArrayList<Factura> facturasActivas;


    // Trabajo hecho por Karla Alejandra Gonzalez, Jorge Isaacs Lozano, Juan David Garcia
    public Hotel() {
        huespedes = new ArrayList<>();
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
        facturasActivas = new ArrayList<>();
        cargarHabitaciones(habitaciones);
        JOptionPane.showMessageDialog(null, "Bienvenido a su hotel.");
    }
    // Huespedes
        //menu
        public void MenuHuespedes() {
            Boolean auxcontrol = false;
            while (!auxcontrol) {
                int Opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu huespedes: " +
                        "\n1. Crear Huesped" +
                        "\n2. Actualizar informacion" +
                        "\n3. Eliminar Huesped" +
                        "\n4. Ver huespedes" +
                        "\n5. volver"));
                switch (Opcion) {
                    case 1 -> CrearHuesped();
                    case 2 -> ActualizarHuesped();
                    case 3 -> EliminarHuesped();
                    case 4 -> VerHuespedes();
                    case 5 -> auxcontrol = true;
                    default -> JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
                }
            }
        }
        //creamos huespedes
        public void CrearHuesped() {
            try {
                int NumeroHuesped = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de huespedes que ingresa: "));
                for (int i = 0; i < NumeroHuesped; i++) {
                    Huesped Huesped = new Huesped(i);
                    huespedes.add(Huesped);
                }
                JOptionPane.showMessageDialog(null,"Huespedes registrado correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
        //actualizamos huespedes
        public void ActualizarHuesped() {
            if (huespedes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay huespedes en este momento");
            } else {
                try {
                    int IdAux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del huesped que desea editar: "));
                    boolean encontrado = false;
                    for (Huesped H : huespedes) {
                        if (H.getId() == IdAux) {
                            H.EditarInformacion();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No se encontró un huesped con ese Id");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }
        //eliminamos huespedes
        public void EliminarHuesped() {
            if (huespedes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay administradores en este momento");
            } else {
                try {
                    int IdAux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del huesped que desea eliminar: "));
                    boolean encontrado2 = false;
                    for (int i = 0; i < huespedes.size(); i++) {
                        Huesped H = huespedes.get(i);
                        if (H.getId() == IdAux) {
                            huespedes.remove(i);
                            encontrado2 = true;
                            JOptionPane.showConfirmDialog(null, "Huesped eliminado correctamente");
                            break;
                        }
                    }
                    if (!encontrado2) {
                        JOptionPane.showMessageDialog(null, "No se encontró un huesped con ese Id");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        }
        public void VerHuespedes() {
            if (huespedes.isEmpty()) {
                JOptionPane.showMessageDialog(null,"No hay huespedes en este momento");
            } else {
                for(Huesped H: huespedes) {
                    H.MostrarInformacion();
                }
            }
        }
    // Habitaciones
    public void cargarHabitaciones(ArrayList<Habitacion>habitaciones) {

        habitaciones.add(new HabitacionSimple(101, "Simple", 80000,true));
        habitaciones.add(new HabitacionSimple(102, "Simple", 80000,true));
        habitaciones.add(new HabitacionDoble(103, "Doble", 120000,true));
        habitaciones.add(new HabitacionDoble(201, "Doble", 120000,true));
        habitaciones.add(new HabitacionFamiliar(202, "Familiar", 150000,true));
        habitaciones.add(new HabitacionFamiliar(203, "Familiar", 150000,true));
        habitaciones.add(new HabitacionSuite(301, "Suite", 200000,true));
        habitaciones.add(new HabitacionSuite(302, "Suite", 200000,true));
        habitaciones.add(new HabitacionSuite(303, "Suite", 200000,true));
    }
    // ver habitaciones
    public void verHabitaciones(ArrayList<Habitacion>habitaciones) {
        for(Habitacion H: habitaciones) {
            H.MostrarInformacion();
        }

    }
    //Reserva
        //menu reserva
    public void MenuReservas() {
        Boolean AuxControl = false;
        while (!AuxControl) {
            int Opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu Reservas: " +
                    "\n1. Crear Reserva" +
                    "\n2. Ver reservas" +
                    "\n3. Eliminar Reservas" +
                    "\n4. Volver"));
            switch (Opcion) {
                case 1 -> CrearReserva();
                case 2 -> VerReservas();
                case 3 -> EliminarReservas();
                case 4 -> AuxControl = true;
                default -> JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
            }
        }
    }
    public void CrearReserva() {

        if (huespedes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay huéspedes registrados.");
            return;
        }
        // Pedir y buscar huésped
        int idH = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del huésped:"));
        Huesped huesped = null;
        for (Huesped h : huespedes) {
            if (h.getId() == idH) { huesped = h; break; }
        }
        if (huesped == null) {
            JOptionPane.showMessageDialog(null, "Huésped no encontrado.");
            return;
        }

        // Mostrar habitaciones disponibles
        StringBuilder sb = new StringBuilder("Habitaciones disponibles:\n\n");
        boolean hayDisponibles = false;
        for (Habitacion h : habitaciones) {
            if (h.getDisponible()) {
                sb.append(h).append("\n");
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles.");
            return;
        }

        // Pedir y buscar habitación
        int numHab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de habitación:"));
        Habitacion habitacion = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numHab) { habitacion = h; break; }
        }
        if (habitacion == null || !habitacion.getDisponible()) {
            JOptionPane.showMessageDialog(null, "Habitación no disponible.");
            return;
        }

        // Pedir fechas
        String entradaStr = JOptionPane.showInputDialog("Fecha de entrada (AAAA-MM-DD):");
        String salidaStr  = JOptionPane.showInputDialog("Fecha de salida  (AAAA-MM-DD):");
        LocalDate fechaEntrada = LocalDate.parse(entradaStr);
        LocalDate fechaSalida  = LocalDate.parse(salidaStr);

        if (!fechaEntrada.isBefore(fechaSalida)) {
            JOptionPane.showMessageDialog(null, "La fecha de entrada debe ser antes de la salida.");
            return;
        }

        // Pedir número de personas
        int personas = Integer.parseInt(JOptionPane.showInputDialog("Número de personas:"));

        // Crear reserva y agregarla
        int idReserva = reservas.size() + 1;
        Reserva reserva = new Reserva(idReserva, huesped, habitacion,
                fechaEntrada, fechaSalida, personas);
        reservas.add(reserva);
        JOptionPane.showMessageDialog(null, "Reserva #" + idReserva + " creada exitosamente.");
    }

    public void VerReservas() {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay reservas en este momento");
        } else {
            StringBuilder nb = new StringBuilder();
            for(Reserva R: reservas) {
                R.MostrarInformacion();
            }
        }
    }


    public void EliminarReservas() {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas en este momento");
        } else {
            try {
                int IdAux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id de la reserva que desea eliminar: "));
                boolean encontrado2 = false;
                for (int i = 0; i < reservas.size(); i++) {
                    Reserva R = reservas.get(i);
                    if (R.getIdReserva() == IdAux) {
                        reservas.remove(i);
                        encontrado2 = true;
                        JOptionPane.showConfirmDialog(null, "Reserva eliminada correctamente");
                        break;
                    }
                }
                if (!encontrado2) {
                    JOptionPane.showMessageDialog(null, "No se encontró una reserva con ese Id");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    //Menu
    public boolean Control1 = true;
    public void MenuPrincipal() {
        while (Control1) {
            int Opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu de opciones: " +
                    "\n1. Huespedes" +
                    "\n2. Ver Habitaciones" +
                    "\n3. Reservas" +
                    "\n4. CheckIn" +
                    "\n5. CheckOut" +
                    "\n6. Servicios" +
                    "\n7. Salir"));
            switch (Opcion) {
                case 1 -> MenuHuespedes();
                case 2 -> verHabitaciones(habitaciones);
                case 3 -> MenuReservas();
                case 4 -> CkeckIn.CheckInAhora(reservas,facturasActivas);
                case 5 -> CheckOut.CheckOutAhora(facturasActivas);
                case 6 -> Servicio.AgregarServicios(facturasActivas);
                case 7 -> Control1 = false;
                default -> JOptionPane.showMessageDialog(null,"ERROR");
            }
        }
    }
}
