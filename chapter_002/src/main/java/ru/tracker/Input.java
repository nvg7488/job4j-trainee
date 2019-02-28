package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public interface Input {
    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     */
    String ask(String question);

    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     * @range массив параметров
     */
    int ask(String question, int[] range) throws MenuOutException;
}