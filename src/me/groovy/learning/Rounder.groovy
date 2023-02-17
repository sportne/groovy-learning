package me.groovy.learning

class Rounder {

   double round(double number, int decimals) {
      double factor = Math.pow(10, decimals)
      return Math.round(number * factor) / factor
   }
}
