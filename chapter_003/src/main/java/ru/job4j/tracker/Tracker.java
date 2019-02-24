package ru.job4j.tracker;
/**
 * Класс Tracker - обёртка над массивом.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Tracker {
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
     * Генерирует ID.
     * @return ID
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
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
     * @param id - ID удаляемой записи
     */
//    public void delete(String id) {
//        for (int index = 0; index < position; index++) {
//            if (this.items[index].getId().equals(id)) {
//                this.items[index] = this.items[position - 1];
//                this.items[position - 1] = null;
//                position--;
//                break;
//            }
//        }
//    }
    /**
     * Вернуть массив из непустых элементов в хранилище.
     * @return - возвращает массив Item
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
//    public Item[] findByName(String key) {
//        Item[] result = new Item[this.position];
//        int newPosition = 0;
//        for (int index = 0; index < this.position; index++) {
//            if (items[index].getName().equals(key)) {
//                result[newPosition] = items[index];
//                newPosition++;
//            }
//        }
//        result = Arrays.copyOf(result, newPosition);
//        return result;
//    }
}