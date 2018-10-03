package ru.job4j.array;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class DoubleArray {
    /**
     * Объединает отсортированные массивы в один.
     * @param arr1 первый массив.
     * @param arr2 второй массив.
     * @return result.
     */
    public int[] doubleArray(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int item, item1, item2;
        for (item1 = 0, item2 = 0, item = 0; item1 < arr1.length && item2 < arr2.length;) {
            result[item++] = (arr1[item1] < arr2[item2]) ? arr1[item1++] : arr2[item2++];
        }
        if (item1 < arr1.length) {
            System.arraycopy(arr1, item1, result, item, arr1.length - item1);
        } else {
            System.arraycopy(arr2, item2, result, item, arr2.length - item2);
        }
        return result;
    }
}