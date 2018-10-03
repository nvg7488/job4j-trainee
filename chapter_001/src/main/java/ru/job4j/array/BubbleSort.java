package ru.job4j.array;
/**
 * Сортировка массива методом перестановки.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class BubbleSort {
    /**
     * Сортирует массив.
     * @param array несотрированный массив.
     * @return сотрированный массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int last = array.length - 1; last > 1; last--) {
            for (int step = 1; step <= last; step++) {
                if (array [step] < array [step - 1]) {
                    temp = array [step];
                    array [step] = array [step - 1];
                    array [step - 1] = temp;
                }
            }
        }
        return array;
    }
}