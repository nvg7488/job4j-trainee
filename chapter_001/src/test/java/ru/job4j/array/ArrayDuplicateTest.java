package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода, удаляющего дубликаты в массиве.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ArrayDuplicateTest {
    /**
     * Test удаления дубликато из массива.
     */
    @Test
    public void removeDuplicateOfArray() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = ad.remove(array);
        String[] value = {"Привет", "Мир", "Супер"};
        assertThat(result, is(value));
    }
}