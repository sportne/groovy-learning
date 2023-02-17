package me.groovy.learning

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

import spock.lang.Specification
import spock.lang.Unroll

class TemperatureConverterSpec extends Specification {
    def "converts valid Celsius to Fahrenheit"() {
        given:
        TemperatureConverter.rounder = { double number, int decimals -> number } as Rounder
       
        when:
        def result = TemperatureConverter.celsiusToFahrenheit(celsius)

        then:
        result <= expected + 0.01 && result >= expected - 0.1

        where:
        celsius | expected
        0       | 32 
        100     | 212 
        -40     | -40 
        -273    | -459.4 
    }
    
    def "converts invalid Celsius to Fahrenheit"() {
       when:
       def result = TemperatureConverter.celsiusToFahrenheit(celsius)

       then:
       def error = thrown(expectedException)
       error.message == expectedMessage

       where:
       celsius | expectedException | expectedMessage
       -1000   | Exception         | "Temperature is below absolute zero"
       -274    | Exception         | "Temperature is below absolute zero"
   }

    @Unroll("converts #fahrenheit Fahrenheit to Celsius")
    def "converts Fahrenheit to Celsius"() {
        when:
        def result = TemperatureConverter.fahrenheitToCelsius(fahrenheit)

        then:
        result == expected

        where:
        fahrenheit | expected
        32         | 0
        212        | 100
        -40        | -40
    }
}
