package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class DoubleArrayTest {
    /**
     * Test sortTrue
     */
    @Test
    public void sortTrue() {
        int[] array = new int[] {1, 2, 3, 5, 7};
        TestArray testArray = new TestArray();
        assertThat(testArray.sort(array), is(true));
    }

    /**
     * Test sortFalse
     */
    @Test
    public void sortFalse() {
        int[] array = new int[] {1, 8, 3, 5, 7};
        TestArray testArray = new TestArray();
        assertThat(testArray.sort(array), is(false));
    }

    /**
     * Test array1 = null
     */
    @Test
    public void array1Null() {
        int[] arr1 = new int[0];
        int[] arr2 = new int[] {2, 4, 6, 8};
        TestArray testArray = new TestArray();
        assertThat(testArray.noNull(arr1, arr2), is(false));
    }

    /**
     * Test array2 = null
     */
    @Test
    public void array2Null() {
        int[] arr1 = new int[] {1, 2, 3, 5, 7};
        int[] arr2 = new int[0];
        TestArray testArray = new TestArray();
        assertThat(testArray.noNull(arr1, arr2), is(false));
    }

    /**
     * Test arraysNONull
     */
    @Test
    public void arraysNONull() {
        int[] arr1 = new int[] {1, 2, 3, 5, 7};
        int[] arr2 = new int[] {2, 4, 6, 8};
        TestArray testArray = new TestArray();
        assertThat(testArray.noNull(arr1, arr2), is(true));
    }

    /**
     * Test doubleArray
     */
    @Test
    public void doubleArrayTest() {
        int[] arr1 = new int[] {1, 2, 3, 5, 7};
        int[] arr2 = new int[] {2, 4, 6, 8};
        int[] expect = new int[] {1, 2, 2, 3, 4, 5, 6, 7, 8};
        DoubleArray da = new DoubleArray();
        assertThat(da.doubleArray(arr1, arr2), is(expect));
    }
}