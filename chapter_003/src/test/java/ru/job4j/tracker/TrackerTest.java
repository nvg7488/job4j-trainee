package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void addItemTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", 0);
        tracker.addItem(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void updateTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("nameAdd", "descAdd", 0L);
        tracker.addItem(item);
        Item updated = tracker.findAll().get(0);
        Item newItem = new Item("nameUpdate", "descUpdate", 0L);
        tracker.update(newItem);
        Item result = tracker.findById(updated.getId());
        assertThat(result.getName(), is("nameUpdate"));
        assertThat(result.getDescription(), is("descUpdate"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("name", "desc", 0L);
        tracker.addItem(item);
        Item deleting = tracker.findAll().get(0);
        String name = deleting.getName();
        tracker.delete(deleting);
        assertThat(tracker.findAll().size(), is(0));
    }
}
