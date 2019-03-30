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
}
