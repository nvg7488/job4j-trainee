package ru.job4j.tracker;
/**
 * Класс ItemShowAll.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemShowAll implements UserAction {
    private int index;
    private String name;
    public ItemShowAll(int index, String name) {
        this.index = index;
        this.name = name;
    }
    @Override
    public int key() {
        return this.index;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        if (tracker.getPosition() == 0) {
            System.out.println("Tracker пустой!");
        } else {
            for (Item item : tracker.findAll()) {
                item.printInfo();
            }
        }
    }
    @Override
    public String info() {
        return String.format("%d, %s", this.index, this.name);
    }
}