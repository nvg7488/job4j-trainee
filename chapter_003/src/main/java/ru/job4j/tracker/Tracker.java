package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.Iterator;
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
    public void update(Item item) {
        for (Item nextItem : this.items) {
            if (nextItem != null && nextItem.getCreate() == item.getCreate()) {
                nextItem.setName(item.getName());
                nextItem.setDescription(item.getDescription());
                nextItem.setCreate(item.getCreate());
                break;
            }
        }
    }
    public void delete(Item item) {
        Item next;
        Iterator<Item> iterator = this.items.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next != null && next.getCreate() == item.getCreate()) {
                iterator.remove();
            }
        }
    }

    public ArrayList<Item> findAll() {
        return this.items;
    }
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item next : this.items) {
            if (next.getName().equals(name)) {
                result.add(next);
            }
        }
        return result.size() > 0 ? result : null;
    }
}
