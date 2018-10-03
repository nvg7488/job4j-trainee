package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода классического поиска перебором.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class FindLoopTest {
    /**
     * Test whenArrayHasLengh5Then0
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {3, 5, 10};
        assertThat(find.indexOf(input, 5), is(1));
    }
}