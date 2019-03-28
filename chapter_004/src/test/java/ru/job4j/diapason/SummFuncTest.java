package ru.job4j.diapason;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class SummFuncTest {
    @Test
    public void testLinear() {
        List<Double> result = SummFunc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void testQuadratic() {
        List<Double> result = SummFunc.diapason(1, 4, x -> x * x - 2 * x + 1);
        List<Double> expected = Arrays.asList(0D, 1D, 4D);
        assertThat(result, is(expected));
    }

    @Test
    public void testLogarithmic() {
        List<Double> result = SummFunc.diapason(1, 3, x -> Math.log(x) / Math.log(2) + 5);
        List<Double> expected = Arrays.asList(5D, 6D);
        assertThat(result, is(expected));
    }
}
