package ru.job4j.calculator;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test методов add, subtraction, multiplication, division; getResult
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class CalculatorTest{
   /**
    * Test add.
    */
   @Test
   public void addTest() {
      Calculator calc = new Calculator();
      calc.add(1D, 1D);
      assertThat(calc.getResult(), is(2D));
   }

   /**
    * Test subtraction.
    */
   @Test
   public void subtractionTest() {
      Calculator calc = new Calculator();
      calc.subtraction(3D, 1D);
      assertThat(calc.getResult(), is(2D));
   }

   /**
    * Test multiplication.
    */
   @Test
   public void multiplicationTest() {
      Calculator calc = new Calculator();
      calc.multiplication(2D, 3D);
      assertThat(calc.getResult(), is(6D));
   }

   /**
    * Test division.
    */
   @Test
   public void divisionTest() {
      Calculator calc = new Calculator();
      calc.division(6D, 3D);
      assertThat(calc.getResult(), is(2D));
   }
}