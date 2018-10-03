package ru.job4j.array;
/**
 * Обертка над строкой.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int step = 0; step < value.length; step++) {
            if (value [step] != data [step]) {
                result = false;
                break;
            }
        }
        return result;
    }
}