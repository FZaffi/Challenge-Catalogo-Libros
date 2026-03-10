package com.alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    // 1. Reutilizamos el cliente para mejorar el rendimiento
    private final HttpClient client = HttpClient.newHttpClient();

    public String obtenerDatos(String url) {
        // 2. Usamos var para mayor legibilidad
        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // 3. Realizamos la petición
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // 4. Verificamos si la respuesta es correcta antes de retornar
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la petición: Código " + response.statusCode());
            }

            return response.body();

        } catch (IOException | InterruptedException e) {
            // 5. Unificamos los catch (Multicatch)
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage());
        }
    }
}