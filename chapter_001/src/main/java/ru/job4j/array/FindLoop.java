package ru.job4j.array;
/**
 * Классический поиск перебором.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class FindLoop {
    /**
     * Поиск перебором.
     * @param data массив.
     * @param el размер массива.
     * @return index.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
