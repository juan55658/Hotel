package Clases;

import javax.swing.*;

public class Acompañante extends Persona {
    private String Parentesco;
    public Acompañante(int id) {
        super(id);
        setParentesco(JOptionPane.showInputDialog("Ingrese su parentezco con el familiar: "));
    }

    @Override
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null,"Datos del acompañante: " + getId() +
                "\nNombre: " + getNombre() +
                "\nDocumento: " + getDocumento() +
                "\nEdad: " + getEdad() +
                "\nTelefono: " + getTelefono() +
                "\nEmail: " + getEmail() +
                "\nParentesco : " + getParentesco());
    }

    @Override
    public void EditarInformacion() {
        setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre completo: "));
        setDocumento(JOptionPane.showInputDialog("Ingrese el nuevo numero de cedula: "));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese La nueva edad: ")));
        setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo telefono:"));
        setEmail(JOptionPane.showInputDialog("Ingrese el nuevo email: "));
        setParentesco(JOptionPane.showInputDialog("Ingrese el nuevo parentesco: "));
    }

    public String getParentesco() {
        return Parentesco;
    }

    public void setParentesco(String parentesco) {
        this.Parentesco = parentesco;
    }
}
