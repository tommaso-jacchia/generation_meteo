package com.generation.meteo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONObject;

public class WeatherService {

    // Configurazione del client per evitare errori di handshake e timeout
    private final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10)) 
            .build();

    public String getRawData(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(10))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 200) {
            throw new Exception("Errore server: Codice " + response.statusCode());
        }
        
        return response.body();
    }

    public double[] getCoords(String json) throws Exception {
        JSONObject obj = new JSONObject(json);
        if (!obj.has("results") || obj.getJSONArray("results").isEmpty()) {
            throw new Exception("Città non trovata.");
        }
        JSONObject firstResult = obj.getJSONArray("results").getJSONObject(0);
        return new double[]{ firstResult.getDouble("latitude"), firstResult.getDouble("longitude") };
    }

    public String getWeatherDescription(String json) {
        int code = new JSONObject(json).getJSONObject("current_weather").getInt("weathercode");
        return switch (code) {
            case 0 -> "Sereno ☀️";
            case 1, 2, 3 -> "Parzialmente Nuvoloso 🌤️";
            case 45, 48 -> "Nebbia 🌫️";
            case 51, 53, 55 -> "Pioggerellina 🌦️";
            case 61, 63, 65 -> "Pioggia 🌧️";
            case 71, 73, 75 -> "Neve ❄️";
            case 95, 96, 99 -> "Temporale ⛈️";
            default -> "Variabile ☁️";
        };
    }

    public double getTemperature(String json) {
        return new JSONObject(json).getJSONObject("current_weather").getDouble("temperature");
    }

    public double getWindSpeed(String json) {
        return new JSONObject(json).getJSONObject("current_weather").getDouble("windspeed");
    }
}