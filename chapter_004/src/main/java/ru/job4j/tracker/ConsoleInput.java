package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, ArrayList<Integer> diapason) {
        boolean bln = false;
        int result = 0;
        int key = Integer.parseInt(this.ask(question));
        for (int nextInt : diapason) {
            if (nextInt == key) {
                bln = true;
                break;
            }
        }
        if (bln) {
            result = key;
        }
        return result;
    }
}
