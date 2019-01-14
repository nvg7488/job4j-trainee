package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ItemUpdate implements UserAction {
    private int index;
    private String name;
    public ItemUpdate(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int key() { return this.index; }

    @Override
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

    @Override
    public String info() { return String.format("%d, %s", this.index, this.name); }
}