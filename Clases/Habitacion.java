package Clases;

import Hotel.Hotel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Habitacion {
    protected String tipo;
    protected int numero;
    protected double precioPorNoche;
    protected boolean disponible;

    public Habitacion(String tipo ,int numero, double precioPorNoche, boolean disponible) {
        this.tipo = tipo;
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        setDisponible(disponible);
    }

    public abstract void MostrarInformacion();

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
