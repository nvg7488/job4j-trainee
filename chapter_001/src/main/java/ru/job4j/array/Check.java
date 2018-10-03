package ru.job4j.array;
/**
 * Массив заполнен true или false.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Check {
    /**
     * Массив заполнен true или false.
     * @param data массив.
     * @return все одной масти.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int step = 1; step < data.length; step++) {
            if (data [step] != data [step - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
