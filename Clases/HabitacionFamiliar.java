package Clases;

import javax.swing.*;

public class HabitacionFamiliar extends Habitacion {
    public HabitacionFamiliar(int numero, String tipo, double precioPorNoche, boolean disponible) {
        super(tipo,numero, precioPorNoche, disponible);

    }
    @Override
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null, "Numero: " + numero + "\nTipo: " + tipo + "\nPrecio por noche: " + precioPorNoche + "\nDisponible: " + disponible);
    }
}
