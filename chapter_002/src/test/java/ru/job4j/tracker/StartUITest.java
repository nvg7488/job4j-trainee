package ru.job4j.tracker;
/**
 * Тесты методов класса StartU.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
class StartUITest {
    private Tracker tracker;
    @Before
    private void newTracker() { this.tracker = new Tracker(); }

    /** Test метода StartUI.addItem. */
    @Test
    public void testAddItem() {
        Input input = new StubInput(new String[] {"0", "test name", "description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /** Test метода StartUI.editItem. */
    @Test
    public void testEditItem() {
        Item item = tracker.addItem(new Item("test name", "description", System.currentTimeMillis()));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    /** Test метода StartUI.delItem. */
    @Test
    public void testDelItem() {
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        String deleteID = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"3", deleteID, "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name2"));
    }

    /** Test метода StartUI.findItemByName. */
    @Test
    public void testFindByName() {
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name0", "description2", 2));
        tracker.addItem(new Item("name2", "description3", 3));
        tracker.addItem(new Item("name0", "description4", 4));
        tracker.addItem(new Item("name3", "description5", 5));
        Item[] result = {
                new Item("name0", "description2", 2),
                new Item("name0", "description4", 4)};
        Item[] find = tracker.findByName("name0");
        Input input = new StubInput(new String[] {"6", "name0", "6"});
        new StartUI(input, tracker).init();
        assertThat(find, is(result));
    }
}