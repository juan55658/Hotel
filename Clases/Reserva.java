package Clases;

import javax.swing.*;
import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int numeroPersonas;

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion,
                   LocalDate fechaEntrada, LocalDate fechaSalida, int numeroPersonas) {

        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroPersonas = numeroPersonas;
    }
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null,"ID: " + getIdReserva() +
                "\nHuesped: " + getHuesped().getNombre() +
                "\nHabitacion: " + getHabitacion().getNumero() +
                "\nFecha entrada: " + getFechaEntrada() +
                "\nFecha Salida: " + getFechaSalida() +
                "\nNumero de personas: " + getNumeroPersonas());
    }
    @Override
    public String toString() {
        return "ID: " + idReserva +
                "\nHuésped: " + huesped.getNombre() +
                "\nHabitación: " + habitacion.getNumero() +
                "\nEntrada: " + fechaEntrada +
                "\nSalida: " + fechaSalida +
                "\nPersonas: " + numeroPersonas +
                "\n------------------------";
    }
    public int getIdReserva() {return idReserva;}
    public Huesped getHuesped() {return huesped;}
    public Habitacion getHabitacion() {return habitacion;}
    public LocalDate getFechaEntrada() {return fechaEntrada;}
    public LocalDate getFechaSalida() {return fechaSalida;}
    public int getNumeroPersonas() {return numeroPersonas;}

    public void setIdReserva(int Idreserva) {this.idReserva = Idreserva;}
    public void setHuesped(Huesped huesped) {this.huesped = huesped;}
    public void setHabitacion(Habitacion habitacion) {this.habitacion = habitacion;}
    public void setFechaEntrada(LocalDate fechaEntrada) {this.fechaEntrada = fechaEntrada;}
    public void setFechaSalida(LocalDate fechaSalida) {this.fechaSalida = fechaSalida;}
    public void setNumeroPersonas(int numeroPersonas) {this.numeroPersonas = numeroPersonas;}
}
