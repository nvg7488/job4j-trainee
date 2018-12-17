package ru.job4j.tracker;
/**
 * Интерфейс для ввода/вывода.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public interface Input {
    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     */
    String ask(String question);
}