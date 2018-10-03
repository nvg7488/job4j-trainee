package ru.job4j.array;
/**
 * Заполнить массив степенями чисел
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Square {
    /**
     * Массив квадратов.
     * @param bound размер массива.
     * @return Массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int arr = 0, num = 1; arr < bound; arr++, num++) {
            rst [arr] = num * num;
        }
        return rst;
    }
}
