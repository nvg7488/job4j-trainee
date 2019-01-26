package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.List;
class ItemUpdate implements UserAction {
    private int index;
    private String name;
    public ItemUpdate(int index, String name) {
        this.index = index;
        this.name = name;
    }
    public int key() { return this.index; }
    public void execute(Input input, Tracker tracker) {
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
    public String info() { return String.format("%d, %s", this.index, this.name); }
}
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public int getActionsLentgh() { return  this.actions.size(); }
    public void fillActions() {
        this.actions.add(this.new ItemAdd(0, "Add Item."));
        this.actions.add(new ItemUpdate(1, "Update Item."));
        this.actions.add(new ItemDelete(2, "Delete Item."));
        this.actions.add(new ItemFindById(3, "Find Item by ID."));
        this.actions.add(new ItemFindByName(4, "Find Item by Name."));
        this.actions.add(new MenuTracker.ItemShowAll(5, "Show all Item."));
    }
    public void select(int key) { this.actions.get(key).execute(this.input, this.tracker); }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class ItemAdd implements UserAction {
        public int index;
        public String name;
        public ItemAdd(int index, String name) {
            this.index = index;
            this.name = name;
        }
        public int key() { return this.index; }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Name: ");
            String desc = input.ask("Desc: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            System.out.println("------------ Новая заявка с Id: " + item.getId() + "-----------");
            tracker.addItem(item);
            System.out.println("\t\tNew Item with ID: " + item.getId());
            System.out.println("\t\tNew Item with Name: " + item.getName());
            System.out.println("\t\tNew Item with Description: " + item.getDescription());
        }
        public String info() { return String.format("%d, %s", this.index, this.name); }
    }
    private static class ItemShowAll implements UserAction {
        public int index;
        public String name;
        public ItemShowAll(int index, String name) {
            this.index = index;
            this.name = name;
        }
        public int key() { return this.index; }
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                System.out.println("Tracker пустой!");
            } else {
                for (Item item : tracker.findAll()) {
                    item.printInfo();
                }
            }
        }
        public String info() { return String.format("%d, %s", this.index, this.name); }
    }
}