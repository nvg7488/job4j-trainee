package ru.job4j.tracker;
/**
 * Класс ItemFindByName.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemFindByName implements UserAction {
    private int index;
    private String name;
    public ItemFindByName(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int key() { return this.index; }

    @Override
    public void execute(Input input, Tracker tracker) {
        String nameToFind = input.ask("Введите имя искомой записи: ");
        Item[] searchResult = tracker.findByName(nameToFind);
        for (Item item : searchResult) {
            item.printInfo();
        }
    }

    @Override
    public String info() { return String.format("%d, %s", this.index, this.name); }
}