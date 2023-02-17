package me.groovy.learning

class TemperatureConverter {
    static final double ABSOLUTE_ZERO_CELSIUS = -273.15

    static Rounder rounder = new Rounder()
    
    static double celsiusToFahrenheit(double celsius) {
        if (celsius < ABSOLUTE_ZERO_CELSIUS) {
            throw new IllegalArgumentException("Temperature is below absolute zero")
        }

        return rounder.round((celsius * 1.8) + 32, 2)
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) / 1.8

        if (celsius < ABSOLUTE_ZERO_CELSIUS) {
            throw new IllegalArgumentException("Temperature is below absolute zero")
        }

        return rounder.round(celsius, 2)
    }
}
