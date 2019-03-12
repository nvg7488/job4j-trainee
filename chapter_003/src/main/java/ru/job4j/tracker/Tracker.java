package ru.job4j.tracker;

/**
 * Класс Tracker - обёртка над массивом.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Tracker {
    /** Массив для хранения заявок. */
    private List<Item> items;
    /** Константа для генерации уникального ID. */
    private static final Random RND = new Random();

    Tracker() {
        this.items = new ArrayList<>();
    }
    /**
     * Добавить элемент в хранилище.
     * @param item - добавляемый элемент
     */
    public Item addItem(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }
    /**
     * Заменить элемент в хранилище.
     * @param item - то, чем заменяем элемент с таким же ID
     */
    public void update(Item item) {
        for (int index = 0; index < this.items.size(); index++) {
            String itemId = this.items.get(index).getId();
            if (item.getId().equals(itemId)) {
                item.setId(itemId);
                this.items.set(index, item);
                break;
            }
        }
    }
    /**
     * Удалить элемент в хранилище.
     * @param item - удаляемая запись
     */
    public void delete(Item item) {
        items.remove(item);
    }

    /**
     * Генерирует ID
     * @return ID
     */
    private String generateId() {
        return String.valueOf(
                System.currentTimeMillis() + RND.nextInt()
        );
    }
    /**
     * Возвращает массив из непустых элементов в хранилище.
     * @return Item
     */
    public List<Item> findAll() {
        return new ArrayList<>(items);
    }
    /**
     * Найти элемент по ID.
     * @param id - указываем ID
     * @return - возвращаемый элемент
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Найти элемент по полю "name".
     * @param key - текст для поиска
     * @return - возвращает нужный элемент.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public int getPosition() {
        return items.size();
    }
}