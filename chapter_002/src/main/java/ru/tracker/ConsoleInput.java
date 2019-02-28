package ru.job4j.tracker;
import java.util.Scanner;
/**
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
    /**
     * Метод ввода/вывода.
     * @param question  вопрос пользователя
     * @return ответ пользователю
     * @range массив параметров
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exit = false;
        for (int value : range) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        if (!exit) {
            throw new MenuOutException("out of Menu Range.");
        }
        return key;
    }
}