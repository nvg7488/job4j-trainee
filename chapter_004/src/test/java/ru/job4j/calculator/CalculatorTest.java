package ru.job4j.calculator;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class CalculatorTest {
    @Test
    public void test() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add, //static call
                buffer::add // non-static call
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}