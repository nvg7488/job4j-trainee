package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StartUI {
    private static final String EXIT = "0";   // выход из программы
    private static final String ADD  = "1";   // добавление заявки
    private static final String SHOW = "2";   // демонстрация всех заявок
    private Input input;
    private Tracker tracker;

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
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
            if (ADD.equals(answer)) {
                this.addItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItem();
            } else if (EXIT.equals(answer)) {
                System.out.println("Выход из программы, пока!");
                exit = true;
            } else {
                System.out.println("Неправильный выбор!");
            }
        }
    }
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("\t1. создание новой заявки");
        System.out.println("\t2. показывает все имеющиеся заявки");
        System.out.println("\t0. выход из программы");
    }

    private void addItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.addItem(item);
        System.out.println("------------ Новая заявка с Id: " + item.getId() + "-----------");
    }
    private void showAllItem() {
        if (tracker.getSize() == 0) {
            System.out.println("Tracker пустой!");
        } else {
            for (Item item : tracker.findAll()) {
                System.out.println();
                item.printInfo();
            }
        }
    }
}