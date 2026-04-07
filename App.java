package com.generation.meteo;

import com.generation.meteo.service.WeatherService;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Forza l'uso dei protocolli TLS moderni (aiuta con l'errore handshake)
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.3");
        
        Scanner scanner = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        System.out.println("=== WEATHER APP v1.0 ===");
        System.out.print("Inserisci il nome della città (es. Roma, London): ");
        String cityInput = scanner.nextLine().trim();

        if (cityInput.isEmpty()) {
            System.out.println("Errore: Il nome della città non può essere vuoto.");
            return;
        }

        try {
            // 1. Geocoding
            String encodedCity = URLEncoder.encode(cityInput, StandardCharsets.UTF_8);
            String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name=" + encodedCity + "&count=1&format=json";
            
            String geoJson = weatherService.getRawData(geoUrl);
            double[] coords = weatherService.getCoords(geoJson);

            // 2. Meteo
            // Nota: %f in alcuni sistemi usa la virgola, l'API vuole il punto. 
            // Usiamo String.format con Locale.US o costruiamo la stringa manualmente.
            String weatherUrl = String.format(java.util.Locale.US, 
                "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true", 
                coords[0], coords[1]);

            System.out.println("DEBUG - Chiamata a: " + weatherUrl); // Così vedi cosa stai inviando
            String weatherJson = weatherService.getRawData(weatherUrl);
            // 3. Estrazione e Stampa
            double temp = weatherService.getTemperature(weatherJson);
            double wind = weatherService.getWindSpeed(weatherJson);
            String desc = weatherService.getWeatherDescription(weatherJson);

            System.out.println("\n---------------------------------");
            System.out.println("📍 CITTÀ:      " + cityInput.toUpperCase());
            System.out.println("☁️  CONDIZIONI: " + desc);
            System.out.println("🌡️  TEMP:       " + temp + "°C");
            System.out.println("💨  VENTO:      " + wind + " km/h");
            System.out.println("---------------------------------");

        } catch (Exception e) {
            System.out.println("\n❌ Errore durante l'esecuzione:");
            System.out.println("Dettaglio: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}