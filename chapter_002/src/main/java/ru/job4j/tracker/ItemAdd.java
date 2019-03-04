package ru.job4j.tracker;
/**
 * Класс ItemAdd.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemAdd implements UserAction {
    private int index;
    private String name;
    public ItemAdd(int index, String name) {
        this.index = index;
        this.name = name;
    }
    @Override
    public int key() {
        return this.index;
    }
    @Override
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
    @Override
    public String info() {
        return String.format("%d, %s", this.index, this.name);
    }
}