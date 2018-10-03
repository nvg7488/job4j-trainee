package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Сортировка массива методом перестановки
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class BubbleSortTest {
    /**
     * Test sortTest
     */
    @Test
    public void sortTest() {
        int[] array = new int[] {5, 1, 2, 7, 3};
        int[] expect = new int[] {1, 2, 3, 5, 7};
        BubbleSort bs = new BubbleSort();
        array = bs.sort(array);
        assertThat(array, is(expect));
    }
}