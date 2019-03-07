package ru.job4j.search;
import java.util.LinkedList;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяеть по полю приоритет.
     * Для вставок использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}