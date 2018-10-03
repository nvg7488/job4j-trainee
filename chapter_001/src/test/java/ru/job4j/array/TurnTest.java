package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода, переворачивающего массив.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class TurnTest {
    /**
     * Test whenBackArray5
     */
    @Test
    public void whenBackArray5() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] expect = new int[] {5, 4, 3, 2, 1};
        Turn turn = new Turn();
        array = turn.back(array);
        assertThat(array, is(expect));
    }

    /**
     * Test whenBackArray6
     */
    @Test
    public void whenBackArray6() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};
        int[] expect = new int[] {6, 5, 4, 3, 2, 1};
        Turn turn = new Turn();
        array = turn.back(array);
        assertThat(array, is(expect));
    }
}