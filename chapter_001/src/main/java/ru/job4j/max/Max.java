package ru.job4j.max;
/**
 * Максимум из двух чисел.
 * @author Николай Говорухин (govoruchin_nv@mail.ru).
 */
public class Max {
    /**
     * Max Temp.
     */
    private int temp;

    /**
     * Максимум из двух чисел.
     * @param first первое число.
     * @param second второе число.
     * @return Большее.
     */
    public int max(int first, int second) {
        int result;
        result = first > second ? first : second;
        return result;
    }
}
