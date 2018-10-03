package ru.job4j.array;
import java.util.Arrays;
/**
 * Удаление дубликатов в массиве.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ArrayDuplicate {
    /**
     * Проверяет, что слово не повторяется.
     * @param array массив строк с повторами.
     * @return массив строк без повторов.
     */
    public String[] remove(String[] array) {
        int length = array.length - 1;
        String temp;
        for (int step = 0; step < length - 1; step++) {
            for (int dubl = step + 1; dubl < length; dubl++) {
                if (array[step].equals(array[dubl])) {
//                    temp = array [dubl];
                    array [dubl] = array [length];
//                    array [length] = temp;
                    length--;
                }
            }
        }
        return Arrays.copyOf(array, length + 1);
    }
}