package ru.job4j.array;
/**
 * Квадратный массив заполнен true или false по диагоналям.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class MatrixCheck {
    /**
     * Квадратный массив заполнен true или false по диагоналям.
     * @param data массив.
     * @return все одной масти.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int x = 1, y = data.length - 1; x < data.length; x++, y--) {
            if ((data [x][x] != data [x - 1][x - 1]) || (data [x][y] != data [x - 1][y - 1])) {
                result = false;
            }
        }
        return result;
    }
}
