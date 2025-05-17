package com.alura.conversor.modelos;

import javax.swing.*;

public class InterfazConversor {
    public void mostrarMenuConversor() {
        Object[] options = {"Convertir Divisas", "Salir"};
        int opcion = JOptionPane.showOptionDialog(null, "¿Qué deseas realizar?", "Conversor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (opcion == 0) {
            ConversorMonedas conversor = new ConversorMonedas();
            conversor.ejecutar();
        } else {
            JOptionPane.showMessageDialog(null, "Programa cerrado");
            System.exit(0);
        }
    }
}