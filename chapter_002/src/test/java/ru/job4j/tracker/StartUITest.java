package ru.job4j.tracker;
/**
 * Тесты методов класса StartU.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    /** Test метода StartUI.addItem. */
    @Test
    public void testAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /** Test метода StartUI.editItem. */
    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.addItem(new Item("test name", "description", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    /** Test метода StartUI.delItem. */
    @Test
    public void testDelItem() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        String deleteID = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"3", deleteID, "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name2"));
    }
}