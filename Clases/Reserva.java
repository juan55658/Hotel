package Clases;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private ArrayList<Acompañante> acompañantes;

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion,
                   LocalDate fechaEntrada, LocalDate fechaSalida, ArrayList<Acompañante> acompañantes) {

        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.acompañantes = acompañantes;
    }
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null,"ID: " + getIdReserva() +
                "\nHuesped: " + getHuesped().getNombre() +
                "\nHabitacion: " + getHabitacion().getNumero() +
                "\nFecha entrada: " + getFechaEntrada() +
                "\nFecha Salida: " + getFechaSalida() +
                "\nAcompañantes: " + getAcompañantes());
    }
    @Override
    public String toString() {
        return "ID: " + idReserva +
                "\nHuésped: " + huesped.getNombre() +
                "\nHabitación: " + habitacion.getNumero() +
                "\nEntrada: " + fechaEntrada +
                "\nSalida: " + fechaSalida +
                "\nAcompañantes: " + acompañantes +
                "\n------------------------";
    }
    public int getIdReserva() {return idReserva;}
    public Huesped getHuesped() {return huesped;}
    public Habitacion getHabitacion() {return habitacion;}
    public LocalDate getFechaEntrada() {return fechaEntrada;}
    public LocalDate getFechaSalida() {return fechaSalida;}
    public ArrayList<Acompañante> getAcompañantes() { return acompañantes; }

    public void setIdReserva(int Idreserva) {this.idReserva = Idreserva;}
    public void setHuesped(Huesped huesped) {this.huesped = huesped;}
    public void setHabitacion(Habitacion habitacion) {this.habitacion = habitacion;}
    public void setFechaEntrada(LocalDate fechaEntrada) {this.fechaEntrada = fechaEntrada;}
    public void setFechaSalida(LocalDate fechaSalida) {this.fechaSalida = fechaSalida;}
    public void setAcompañantes(ArrayList<Acompañante> acompañantes) {this.acompañantes = acompañantes;}
}
