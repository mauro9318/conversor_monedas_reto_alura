package com.alura.conversor.modelos;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiDivisas {

    private static final String API_KEY = "API+KEY";  // Reemplaza con tu clave real

    public static double obtenerTasa(String from, String to) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        String cuerpo = respuesta.body();
        System.out.println("Respuesta de la API: " + cuerpo);

        JSONObject json = new JSONObject(cuerpo);

        if (json.has("conversion_rate")) {
            return json.getDouble("conversion_rate");
        } else {
            throw new RuntimeException("No se encontró 'conversion_rate' en la respuesta.");
        }
    }
}
