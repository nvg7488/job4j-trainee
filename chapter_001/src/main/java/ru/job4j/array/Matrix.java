package ru.job4j.array;
/**
 * Двухмерный массив, таблица умножения.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Matrix {
    /**
     * Таблица умножения.
     * @param size размер массива.
     * @return массив.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table.length; y++) {
                table [x][y] = (x + 1) * (y + 1);
            }
        }
        return table;
    }
}