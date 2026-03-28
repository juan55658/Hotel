package Clases;

import javax.swing.*;

public abstract class Persona {
    protected String nombre, documento, telefono, email;
    protected int Id, edad;

    public Persona(int Id) {
        setId(Id + 1);
        setNombre(JOptionPane.showInputDialog("Ingrese su nombre completo: "));
        setDocumento(JOptionPane.showInputDialog("Ingrese su numero de documento: "));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad: ")));
        setTelefono(JOptionPane.showInputDialog("Ingrese su telefono: "));
        setEmail(JOptionPane.showInputDialog("Ingrese su email: "));
    }

    public abstract void MostrarInformacion();
    public abstract void EditarInformacion();

    public int getId() {return Id;}
    public String getNombre() {return nombre;}
    public String getDocumento() {return documento;}
    public int getEdad() {return edad;}
    public String getTelefono() {return telefono;}
    public String getEmail() {return email;}

    public void setId(int Id) {this.Id = Id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDocumento(String Documento) {this.documento = Documento;}
    public void setEdad(int Edad) {this.edad = Edad;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setEmail(String email) {this.email = email;}
}
