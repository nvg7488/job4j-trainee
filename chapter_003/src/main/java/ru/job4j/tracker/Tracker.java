package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.Random;
public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private static final Random RND = new Random();
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }

    public Item addItem(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return this.items;
    }
}
