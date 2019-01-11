package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
/**
 * Класс StartUI: точка входа в программу.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StartUI {
    /** Получение данных от пользователя. */
    private Input input;
    /** Хранилище заявок. */
    private Tracker tracker;

    /** Точка входа в программу. */
    public static void main(String[] args) { new StartUI(new ConsoleInput(), new Tracker()).init(); }

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /** Метод циклического запроса действия. */
    public StartUI init() {
        boolean exit;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int index = 0; index < menu.getActionsLentgh(); index++) {
            range.add(index);
        }
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select: ")));
            exit = !"y".equals(this.input.ask("Exit? (y): "));
        } while (exit);
        return null;
    }
}