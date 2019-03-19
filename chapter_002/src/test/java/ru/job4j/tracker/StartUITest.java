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
public class StartUITest {
    private Tracker tracker;
    @Before
    public void newTracker() {
        this.tracker = new Tracker();
    }

    /** Test метода StartUI.addItem. */
    @Test
    public void testAddItem() {
        Input input = new StubInput(new String[] {"1", "test name", "description", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /** Test метода StartUI.editItem. */
    @Test
    public void testEditItem() {
        long id = System.currentTimeMillis();
        Item item = tracker.addItem(new Item("test name", "description", id));
        Input input = new StubInput(new String[]{
                "1", "test name", "description",
                "3", item.getId(), "test replace", "description",
                "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }
    /** Test метода StartUI.delItem. */
    @Test
    public void testDelItem() {
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        String deleteID = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"4", deleteID, "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name2"));
    }
    /** Test метода StartUI.findItemByName. */
    @Test
    public void testFindByName() {
        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        Item item2 = new Item("name0", "description2", 2);
        tracker.addItem(item2);
        Item item3 = new Item("name2", "description3", 3);
        tracker.addItem(item3);
        Item item4 = new Item("name0", "description4", 4);
        tracker.addItem(item4);
        Item item5 = new Item("name3", "description5", 5);
        tracker.addItem(item5);
        Item[] result = new Item[]{item2, item4};
        Item[] find = tracker.findByName("name0");
        Input input = new StubInput(new String[] {"6", "name0", "0"});
        new StartUI(input, tracker).init();
        assertThat(find, is(result));
    }
    /** Test метода StartUI.showAllItem. */
    @Test
    public void testShowAllItem() {
        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        Item item2 = new Item("name0", "description2", 2);
        tracker.addItem(item2);
        Item item3 = new Item("name2", "description3", 3);
        tracker.addItem(item3);
        Item item4 = new Item("name0", "description4", 4);
        tracker.addItem(item4);
        Item item5 = new Item("name3", "description5", 5);
        tracker.addItem(item5);
        Item[] result = new Item[]{item1, item2, item3, item4, item5};
        Item[] find = tracker.findAll();
        Input input = new StubInput(new String[] {"2", "0"});
        new StartUI(input, tracker).init();
        assertThat(find, is(result));
    }
    /** Test метода StartUI.findItemById. */
    @Test
    public void testFindItemById() {
        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        Item item2 = new Item("name0", "description2", 2);
        tracker.addItem(item2);
        Item item3 = new Item("name2", "description3", 3);
        tracker.addItem(item3);
        Item item4 = new Item("name0", "description4", 4);
        tracker.addItem(item4);
        Item item5 = new Item("name3", "description5", 5);
        tracker.addItem(item5);
        Item[] result = new Item[]{item1};
        Item find = tracker.findById(item1.getId());
        Input input = new StubInput(new String[] {"5", item1.getId(), "0"});
        new StartUI(input, tracker).init();
        assertThat(find, is(result));
    }
}