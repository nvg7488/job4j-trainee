package ru.job4j.calculate;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода echo
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class CalculateTest{
   /**
    * Test echo.
    */
   @Test
   public void whenTakeNameThenTreeEchoPlusName() {
      String input = "Govoruchin Nikolay";
      String expert = "Echo, echo, echo : Govoruchin Nikolay";
      Calculate calc = new Calculate();
      String result = calc.echo(input);
      assertThat(result, is(expert));
   }
}