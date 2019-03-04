package ru.job4j.tracker;
/**
 * Класс теста интерфейса ввода/вывода.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;
    /**
     * Конструктор.
     * @param answers массив аргументов
     */
    public StubInput(final String[] answers) {
        this.answers = answers;
    }
    /**
     * Метод ввода/вывода.
     * @param question вопрос пользователя
     * @return ответ пользователю
     */
    public String ask(String question) {
        return this.answers[this.position++];
    }
}