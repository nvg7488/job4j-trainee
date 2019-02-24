package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}