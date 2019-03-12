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
}