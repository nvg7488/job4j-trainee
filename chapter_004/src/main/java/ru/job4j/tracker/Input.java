package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
public interface Input {
    String ask(String question);
    int ask(String question, ArrayList<Integer> diapason);
}
