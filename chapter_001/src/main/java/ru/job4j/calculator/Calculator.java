/**
 * Calculator
 */
package ru.job4j.calculator;
/**
 * Класс для вычисления арифметических операций.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Calculator {
   private double result;

   /**
    * Method add.
    * @param first - first.
    * @param second - second.
    */
   public void add(double first, double second) {
      this.result = first + second;
   }

   /**
    * Method subtraction.
    * @param first - first.
    * @param second - second.
    */
   public void subtraction(double first, double second) {
      this.result = first - second;
   }

   /**
    * Method multiplication.
    * @param first - first.
    * @param second - second.
    */
   public void multiplication(double first, double second) {
      this.result = first * second;
   }

   /**
    * Method division.
    * @param first - first.
    * @param second - second.
    */
   public void division(double first, double second) {
      this.result = first / second;
   }

   /**
    * Method getResult.
    * @return result.
    */
   public double getResult() {
      return this.result;
   }
}