package me.groovy.learning

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import spock.lang.Specification

class CalculatorSpec extends Specification {
   Calculator calculator = new Calculator()

   def "test addition"() {
      expect:
      calculator.add(2, 3) == 5
   }

   def "test subtraction"() {
      expect:
      calculator.subtract(5, 3) == 2
   }
}

