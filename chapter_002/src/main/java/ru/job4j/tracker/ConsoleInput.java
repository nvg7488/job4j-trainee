package ru.job4j.tracker;
import java.util.Scanner;
/**
 * Класс для ввода/вывода.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
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