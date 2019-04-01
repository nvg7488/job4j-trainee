package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    @Test
    public void addItemTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "test name", "description", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void showAllItemTest() {
        Tracker tracker = new Tracker();
        ArrayList<Item> result = new ArrayList<>();

        Item item1 = new Item("name1", "description1", 1);
        tracker.addItem(item1);
        result.add(item1);

        Item item2 = new Item("name0", "description2", 2);
        tracker.addItem(item2);
        result.add(item2);

        Item item3 = new Item("name2", "description3", 3);
        tracker.addItem(item3);
        result.add(item3);

        Item item4 = new Item("name0", "description4", 4);
        tracker.addItem(item4);
        result.add(item4);

        Item item5 = new Item("name3", "description5", 5);
        tracker.addItem(item5);
        result.add(item5);

        ArrayList<Item> find = tracker.findAll();
        Input input = new StubInput(new String[] {"2", "0"});
        new StartUI(input, tracker).init();
        assertThat(find, is(result));
    }

    /** Test метода StartUI.editItem. */
    @Test
    public void editItemTest() {
        Tracker tracker = new Tracker();
        long id = System.currentTimeMillis();
        Item item = tracker.addItem(new Item("test name", "description", id));
        Input input = new StubInput(new String[]{
                "1", "test name", "description",
                "3", item.getId(), "test replace", "description",
                "0"});
        new StartUI(input, tracker).init();
        ArrayList<Item> result = tracker.findByName("test replace");
        assertThat(tracker.findByName("test replace"), is(result));
    }
}