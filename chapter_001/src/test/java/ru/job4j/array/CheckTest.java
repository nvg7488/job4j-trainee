package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода, проверяющего, что массив заполнен true или false.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class CheckTest {
    /**
     * Test whenBackArray3
     */
    @Test
    public void whenCheck3() {
        boolean[] data = new boolean[] {false, false, false};
        Check check = new Check();
        boolean result = check.mono(data);
        assertThat(result, is(true));
    }

    /**
     * Test whenBackArray4
     */
    @Test
    public void whenCheck4() {
        boolean[] data = new boolean[] {true, true, false, true};
        Check check = new Check();
        boolean result = check.mono(data);
        assertThat(result, is(false));
    }
}