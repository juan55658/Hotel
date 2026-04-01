package Clases;

import javax.swing.*;

public class HabitacionSuite  extends Habitacion {
    public HabitacionSuite(int numero, String tipo, double precioPorNoche, boolean disponible) {
        super(tipo,numero, precioPorNoche, disponible);

    }
    @Override
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null, "Numero: " + numero + "\nTipo: " + tipo + "\nPrecio por noche: " + precioPorNoche + "\nDisponible: " + disponible);
    }
}
