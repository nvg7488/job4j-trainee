package ru.job4j.loop;
/**
 * Программа, вычисляющую факториал.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Factorial {
    /**
     * Цикл for.
     * @param n!.
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int step = 2; step <= n; step++) {
            result *= step;
        }
        return result;
    }
}
