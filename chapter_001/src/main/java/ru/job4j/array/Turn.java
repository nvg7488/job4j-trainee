package ru.job4j.array;
/**
 * Перевернуть массив.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Turn {
    /**
     * Массив в обратом порядке.
     * @param array массив.
     * @return Массив.
     */
    public int[] back(int[] array) {
        int temp;
        for (int first = 0, last = array.length - 1; first < last; first++, last--) {
            temp = array [first];
            array [first] = array [last];
            array [last] = temp;
        }
        return array;
    }
}
