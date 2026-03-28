package Clases;

import javax.swing.*;

public class Huesped extends Persona {
    private String ContactoE;

    public Huesped(int id) {
        super(id);
        setContactoE(JOptionPane.showInputDialog("Ingrese su contacto de emergencia: "));
    }

    @Override
    public void MostrarInformacion() {
        JOptionPane.showMessageDialog(null,"ID: " + getId() +
                "\nNombre: " + getNombre() +
                "\nDocumento: " + getDocumento() +
                "\nEdad: " + getEdad() +
                "\nTelefono: " + getTelefono() +
                "\nEmail: " + getEmail() +
                "\nContacto emergencia: " + getContactoE());
    }

    @Override
    public void EditarInformacion() {
        setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre completo: "));
        setDocumento(JOptionPane.showInputDialog("Ingrese el nuevo numero de cedula: "));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese La nueva edad: ")));
        setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo telefono:"));
        setEmail(JOptionPane.showInputDialog("Ingrese el nuevo email: "));
        setContactoE(JOptionPane.showInputDialog("Ingrese el nuevo contacto de emergencia: "));
    }

    public String getContactoE() { return ContactoE; }
    public void setContactoE(String contactoE)  { this.ContactoE = contactoE; }

}
