package ru.job4j.tracker;
/**
 * Класс для ввода/вывода.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.Scanner;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод ввода/вывода.
     * @param question вопрос пользователя
     * @return ответ пользователю
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
