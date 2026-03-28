package Clases;

import Hotel.Hotel;

import javax.swing.*;
import java.util.ArrayList;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precioPorNoche, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        setDisponible(disponible);
    }
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null,"Numero: " + numero +
                "\nTipo: " + tipo +
                "\nPrecioPorNoche: " + precioPorNoche +
                "\nDisponible: " + disponible);

    }
    @Override
    public String toString() {
        return "Numero: " + numero +
                "\nTipo: " + tipo +
                "\nPrecio noche: " + precioPorNoche +
                "\nDisponible: " + disponible;
    }

    public int getNumero() {return numero;}
    public String getTipo() {return tipo;}
    public double getPrecioPorNoche() {return precioPorNoche;}
    public boolean getDisponible() {return disponible;}

    public void SetNumero(int numero) {this.numero = numero;}
    public void SetTipo(String tipo) {this.tipo = tipo;}
    public void SetPrecioNoche(double precioPorNoche) {this.precioPorNoche = precioPorNoche;}
    public void setDisponible(boolean disponible) {this.disponible = disponible;}
}
