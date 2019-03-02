package ru.job4j.loop;
/**
 * Сумма чётных чисел.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Counter {
    /**
     * Цикл for.
     * @param start первое число.
     * @param finish последнее число.
     * @return Сумма.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int step = start; step <= finish; step++) {
            if (step % 2 == 0) {
                result += step;
            }
        }
        return result;
    }
}
