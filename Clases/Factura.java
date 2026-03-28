package Clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Factura {
    private int idFactura;
    private Reserva reserva;
    private ArrayList<Servicio> servicios;
    private LocalDate fechaEmision;

    public Factura(int idFactura, Reserva reserva) {
        this.idFactura = idFactura;
        this.reserva = reserva;
        this.servicios = new ArrayList<>();
        this.fechaEmision = LocalDate.now();
    }

    public void agregarServicio(Servicio s) {
        servicios.add(s);
    }


    public long calcularNoches() {
        return ChronoUnit.DAYS.between(
                reserva.getFechaEntrada(),
                reserva.getFechaSalida()
        );
    }

    public double calcularTotalHabitacion() {
        return calcularNoches() * reserva.getHabitacion().getPrecioPorNoche();
    }

    public double calcularTotalServicios() {
        double total = 0;
        for (Servicio s : servicios) {
            total += s.getSubtotal();
        }
        return total;
    }


    public double calcularTotalFinal() {
        return calcularTotalHabitacion() + calcularTotalServicios();
    }

    public int getIdFactura()               { return idFactura; }
    public Reserva getReserva()             { return reserva; }
    public ArrayList<Servicio> getServicios() { return servicios; }
    public LocalDate getFechaEmision()      { return fechaEmision; }


}
