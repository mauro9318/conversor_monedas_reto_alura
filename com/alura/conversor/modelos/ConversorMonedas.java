package com.alura.conversor.modelos;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConversorMonedas {
    private final DecimalFormat formato = new DecimalFormat("#.##");

    public void ejecutar() {
        Map<String, String> opciones = new LinkedHashMap<>();
        opciones.put("Bolivianos a Dólares", "USD");
        opciones.put("Bolivianos a Euros", "EUR");
        opciones.put("Bolivianos a Libras Esterlinas", "GBP");
        opciones.put("Bolivianos a Yenes", "JPY");
        opciones.put("Bolivianos a Wones", "KRW");

        boolean continuar = true;

        while (continuar) {
            String[] menu = opciones.keySet().toArray(new String[0]);
            String seleccion = (String) JOptionPane.showInputDialog(null, "Elige una opción:",
                    "Conversión", JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

            if (seleccion == null) break;

            String entrada = JOptionPane.showInputDialog(null, "Ingresa cantidad en BOB:");
            if (entrada == null) break;

            try {
                double monto = Double.parseDouble(entrada);
                String monedaDestino = opciones.get(seleccion);
                double tasa = ApiDivisas.obtenerTasa("BOB", monedaDestino);
                double resultado = CalculadoraCambio.convertir(monto, tasa);

                JOptionPane.showMessageDialog(null,
                        monto + " BOB son " + formato.format(resultado) + " " + monedaDestino +
                                "\n(Tasa actual: 1 BOB = " + formato.format(tasa) + " " + monedaDestino + ")");

                int seguir = JOptionPane.showConfirmDialog(null, "¿Deseas hacer otra conversión?",
                        "Confirmar", JOptionPane.YES_NO_OPTION);
                if (seguir != JOptionPane.YES_OPTION) {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ingresar un número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}