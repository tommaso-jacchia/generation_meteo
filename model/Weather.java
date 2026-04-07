package com.generation.meteo.model;

/**
 * Weather data model class
 */
public class Weather {
    private String city;
    private double temperature;
    private String condition;
    private double humidity;
    private double windSpeed;

    public Weather() {}

    public Weather(String city, double temperature, String condition, double humidity, double windSpeed) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    // Getters
    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    // Setters
    public void setCity(String city) {
        this.city = city;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", condition='" + condition + '\'' +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
