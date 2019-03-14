package ru.job4j.tracker;
/**
 * Тесты методов класса Tracker.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    /** Тест добавления одного элемента в пустой трекер. */
    @Test
    public void testAddOneItemInEmptyTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("NAME", "Description", 1);
        tracker.addItem(item);
        List<Item> actual = tracker.findAll();
        Assert.assertEquals(actual.size(), 1);
    }
    /** Тест добавления двух элементов в пустой трекер. */
    @Test
    public void testAddTwoItemsInEmptyTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        Item item2 = new Item("name2", "description2", 2);
        tracker.addItem(item2);
        Assert.assertEquals(tracker.getSize(), 2);
    }
    /** Тест функции Update. */
    @Test
    public void testUpdate() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "description", 1);
        tracker.addItem(item);
        String id = item.getId();
        tracker.update(item);
        assertThat(tracker.findById(id), is(item));
        assertThat(tracker.findByName("name").size(), is(1));
    }
    /** Тест функции Delete. */
    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        Item item2 = new Item("name2", "description2", 2);
        tracker.addItem(item2);
        tracker.delete(item1);
        Assert.assertEquals(tracker.findAll().size(), 1);
    }
}