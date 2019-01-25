package ru.job4j.tracker;
/**
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

    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     * @range массив параметров
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}