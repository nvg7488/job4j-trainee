package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test квадратного массива, заполненого true или false по диагоналям.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class MatrixCheckTest {
    /**
     * Test массива с чётной стороной.
     */
    @Test
    public void when2true() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] data = {
                {true, false},
                {false, true}
        };
        assertThat(matrix.mono(data), is(true));
    }

    /**
     * Test массива с нечётной стороной.
     */
    @Test
    public void when3false() {
        MatrixCheck matrix = new MatrixCheck();
        boolean[][] data = {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        assertThat(matrix.mono(data), is(false));
    }
}