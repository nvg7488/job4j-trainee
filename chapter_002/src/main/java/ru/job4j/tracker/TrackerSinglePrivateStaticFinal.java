package ru.job4j.tracker;
/**
 * Класс Tracker - обёртка над массивом.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.Arrays;
import java.util.Random;
public class TrackerSinglePrivateStaticFinal {
    /** Массив для хранения заявок. */
    private Item[] items = new Item[100];
    /** Указатель ячейки для новой заявки. */
    private int position = 0;
    /** Константа для генерации уникального ID. */
    private static final Random RND = new Random();

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinal INSTANCE = new TrackerSinglePrivateStaticFinal();
    }
    public static TrackerSinglePrivateStaticFinal getInstance() { return Holder.INSTANCE; }
    public static void main(String[] args) {
        TrackerSinglePrivateStaticFinal tracker = TrackerSinglePrivateStaticFinal.getInstance();
    }
    /**
     * Добавить элемент в хранилище.
     * @param model - добавляемый элемент
     */
    public Item addItem(Item model) { return model; }

    /**
     * Генерирует ID.
     * @return ID
     */
    private String generateId() { return String.valueOf(System.currentTimeMillis() + RND.nextInt()); }
    /**
     * Заменить элемент в хранилище.
     * @param item - то, чем заменяем элемент с таким же ID
     */
    public void update(Item item) {
        String idToUpdate = item.getId();
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(idToUpdate)) {
                this.items[index] = item;
                break;
            }
        }
    }
    /**
     * Удалить элемент в хранилище.
     * @param id - ID удаляемой записи
     */
    public void delete(String id) {
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = this.items[position - 1];
                this.items[position - 1] = null;
                position--;
                break;
            }
        }
    }
    /**
     * Вернуть массив из непустых элементов в хранилище.
     * @return - возвращает массив Item
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * Найти элемент по ID.
     * @param id - указываем ID
     * @return - возвращаемый элемент
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId().equals(id)) {
                result = this.items[index];
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
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int newPosition = 0;
        for (int index = 0; index < this.position; index++) {
            if (items[index].getName().equals(key)) {
                result[newPosition] = items[index];
                newPosition++;
            }
        }
        result = Arrays.copyOf(result, newPosition);
        return result;
    }
    /** Геттер указатель ячейки */
    public int getPosition() { return position; }
}