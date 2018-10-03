package ru.job4j.array;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class TestArray {
    /**
     * Проверяет сортированность массива.
     * @param array отсортированный массив.
     * @return boolean.
     */
    public boolean sort(int[] array) {
        boolean result = true;
        for (int item = 1; item < array.length; item++) {
            if (array [item] < array [item - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Проверяет, что оба массива не пустые.
     * @param arr1 первый отсортированный массив.
     * @param arr2 второй отсортированный масси.
     * @return boolean.
     */
    public boolean noNull(int[] arr1, int[] arr2) {
        boolean result = true;
        if ((arr1.length == 0) || (arr2.length == 0)) {
            result = false;
        }
        return result;
    }
}