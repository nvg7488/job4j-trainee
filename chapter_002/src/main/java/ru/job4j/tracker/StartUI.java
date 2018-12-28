package ru.job4j.tracker;
/**
 * Класс StartUI: точка входа в программу.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class StartUI {
    private static final String EXIT = "0";   // выход из программы
    private static final String ADD  = "1";   // добавление заявки
    private static final String SHOW = "2";   // демонстрация всех заявок
    private static final String EDIT = "3";   // редактирование заявки
    private static final String DEL  = "4";   // удаление заявки
    private static final String ID   = "5";   // поиск записи по ID
    private static final String NAME = "6";   // поиск записи по имени
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
                this.findItemById();
            } else if (NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                System.out.println("Выход из программы, пока!");
                exit = true;
            } else {
                System.out.println("Неправильный выбор!");
            }
        }
    }

    /** Метод показывает пользователю меню. */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("\t1. создание новой заявки");
        System.out.println("\t2. показывает все имеющиеся заявки");
        System.out.println("\t3. редактирование заявки");
        System.out.println("\t4. удаление заявки");
        System.out.println("\t5. поиск записи по ID");
        System.out.println("\t6. поиск записи по имени");
        System.out.println("\t0. выход из программы");
    }

    /** Метод реализует добавленяи новый заявки в хранилище. */
    private void addItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.addItem(item);
        System.out.println("------------ Новая заявка с Id: " + item.getId() + "-----------");
    }

    /** Метод показывает все имеющиеся заявки. */
    private void showAllItem() {
        if (tracker.getPosition() == 0) {
            System.out.println("Tracker пустой!");
        } else {
            for (Item item : tracker.findAll()) {
                System.out.println();
                item.printInfo();
            }
        }
    }

    /** Метод редактирования заявки. */
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

    /** Метод удаления заявки. */
    private void delItem() {
        tracker.delete(input.ask("Введите ID записи, подлежащей удалению: "));
    }

    /** Метод поиска записи по ID. */
    private void findItemById() {
        Item itemToFind = tracker.findById(input.ask("Введите ID искомой записи: "));
        itemToFind.printInfo();
    }

    /** Метод поиска записи по имени. */
    private void findItemByName() {
        String nameToFind = input.ask("Введите имя искомой записи: ");
        Item[] searchResult = tracker.findByName(nameToFind);
        for (Item item : searchResult) {
            System.out.println();
            item.printInfo();
        }
    }
}