package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
/**
 * Точка входа в программу.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StartUI {
    private int[] ranges  = new int[] {0, 1, 2, 3, 4, 5, 6};
    /** Получение данных от пользователя. */
    private Input input;
    /** Хранилище заявок. */
    private Tracker tracker;

    /** Точка входа в программу. */
    public static void main(String[] args) {
        TrackerSingleEnum trackerEnum = TrackerSingleEnum.INSTANCE;
        TrackerSingleStatic trackerSingleStatic = TrackerSingleStatic.getInstance();
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

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
        UserAction ItemDelete = new UserAction() {
            public int index;
            public String name;
//            public int getIndex (int index) { this.index = index; }
            public int key() {  return this.index; }
            public void execute(Input input, Tracker tracker) { tracker.delete(input.ask("Введите ID записи, подлежащей удалению: ")); }
            public String info() { return String.format("%d, %s", this.index, this.name); }
        };
        menu.actions.add(ItemDelete);
        for (int index = 0; index < menu.getActionsLentgh(); index++) {
            range.add(index);
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
            exit = !"y".equals(this.input.ask("Exit? (y): "));
        } while (exit);
        return null;
    }
}