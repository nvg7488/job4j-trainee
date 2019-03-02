package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test класса вычисления большего.
 * @author Николай Говорухин (govoruchin_nv@mail.ru).
 */
public class MaxTest {
    /**
     * Test метода вычисления максимума двух чисел.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test метода вычисления максимума трёх чисел.
     */
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 2);
        assertThat(result, is(3));
    }
}
