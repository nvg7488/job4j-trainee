package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test класса подсчёта чётных чисел
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class CounterTest {
    /**
     * Test сумма чётных в диапазоне от 1 до 10 = 30
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}