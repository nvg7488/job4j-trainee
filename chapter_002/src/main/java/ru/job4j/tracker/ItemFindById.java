package ru.job4j.tracker;
/**
 * Класс ItemFindById.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemFindById implements UserAction {
    private int index;
    private String name;
    public ItemFindById(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int key() { return this.index; }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item itemToFind = tracker.findById(input.ask("Введите ID искомой записи: "));
        itemToFind.printInfo();
    }

    @Override
    public String info() { return String.format("%d, %s", this.index, this.name); }
}