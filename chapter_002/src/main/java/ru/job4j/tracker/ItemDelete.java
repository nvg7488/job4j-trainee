package ru.job4j.tracker;
/**
 * Класс ItemDelete.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemDelete implements UserAction {
    private int index;
    private String name;
    public ItemDelete(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int key() { return this.index; }

    @Override
    public void execute(Input input, Tracker tracker) { tracker.delete(input.ask("Введите ID записи, подлежащей удалению: ")); }

    @Override
    public String info() { return String.format("%d, %s", this.index, this.name); }
}