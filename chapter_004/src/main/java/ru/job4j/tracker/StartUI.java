package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.function.Consumer;
public class StartUI {
    private static final String EXIT = "0";   // выход из программы
    private static final String ADD  = "1";   // добавление заявки
    private static final String SHOW = "2";   // демонстрация всех заявок
    private static final String EDIT = "3";   // редактирование заявки
    private static final String DEL  = "4";   // удаление заявки
    private static final String ID   = "5";   // поиск записи по ID
    private static final String NAME = "6";   // поиск записи по имени
    private Input input;
    private Tracker tracker;
    private Consumer<String> consumer;

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker(), System.out::println).init();
    }
    public StartUI(Input input, Tracker tracker, Consumer<String> consumer) {
        this.input = input;
        this.tracker = tracker;
        this.consumer = consumer;
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
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.delItem();
            } else if (ID.equals(answer)) {
                this.showId();
            } else if (NAME.equals(answer)) {
                this.showName();
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
        System.out.println("\t3. редактирование заявки");
        System.out.println("\t4. удаление заявки");
        System.out.println("\t0. выход из программы");
    }

    private void addItem() {
        consumer.accept("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.addItem(item);
        consumer.accept("------------ Новая заявка с Id: " + item.getId() + "-----------");
    }
    private void showId() {
        String idToShow = input.ask("Введите ID записи, подлежащей просмотра: ");
        if (tracker.findById(idToShow) == null) {
            consumer.accept("Запись с введённым ID не существует.");
        } else {
            tracker.findById(idToShow);
        }
    }
    private void showName() {
        String nameToShow = input.ask("Введите Name записи, подлежащей просмотра: ");
        if (tracker.findByName(nameToShow) == null) {
            consumer.accept("Запись с введённым именем не существует.");
        } else {
            tracker.findByName(nameToShow);
        }
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
    private void editItem() {
        String idToEdit = input.ask("Введите ID записи, подлежащей редактированию: ");
        if (tracker.findById(idToEdit) == null) {
            System.out.println("Запись с введённым ID не существует.");
        } else {
            String newName = input.ask("Введите новой имя для редактируемой записи: ");
            String newDescription = input.ask("Введите новое описание для редактируемой записи: ");
            Item item = new Item(newName, newDescription, System.currentTimeMillis());
            item.setId(idToEdit);
            tracker.update(item);
        }
    }
    private void delItem() {
        String idToEdit = input.ask("Введите ID записи, подлежащей удалению: ");
        if (tracker.findById(idToEdit) == null) {
            System.out.println("Запись с введённым ID не существует.");
        } else {
            tracker.delete(tracker.findById(idToEdit));
        }
    }
}