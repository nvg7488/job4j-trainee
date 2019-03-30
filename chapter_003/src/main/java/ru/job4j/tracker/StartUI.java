package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StartUI {
    private static final String EXIT = "0";   // выход из программы
    private Input input;
    private Tracker tracker;

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker());
    }
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (EXIT.equals(answer)) {
                System.out.println("Выход из программы, пока!");
                exit = true;
            } else {
                System.out.println("Неправильный выбор!");
            }
        }
    }
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("\t0. выход из программы");
    }
}
