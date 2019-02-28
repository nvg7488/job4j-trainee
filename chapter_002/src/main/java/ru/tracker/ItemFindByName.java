package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class ItemFindByName extends BaseAction {
    public ItemFindByName(int key, String name) { super (key, name); }
    public void execute(Input input, Tracker tracker) {
        String nameToFind = input.ask("Введите имя искомой записи: ");
        Item[] searchResult = tracker.findByName(nameToFind);
        for (Item item : searchResult) { item.printInfo(); }
    }
}