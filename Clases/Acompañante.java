package Clases;

import javax.swing.*;

public abstract class Acompañante extends Persona {
    private String Parentesco;
    public Acompañante(int id) {
        super(id +1);
        setParentesco(JOptionPane.showInputDialog("Ingrese su parentezco con el familiar: "));
    }

    public String getParentesco() {
        return Parentesco;
    }

    public void setParentesco(String parentesco) {
        this.Parentesco = parentesco;
    }
}
