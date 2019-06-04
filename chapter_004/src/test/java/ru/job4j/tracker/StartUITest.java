package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void addItemTest() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "test name", "description", "0"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void showIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "description1", 1);
        tracker.addItem(item);
        tracker.addItem(new Item("name2", "description2", 2));
        Input input = new StubInput(new String[] {"5", item.getId(), "0"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findById(item.getId()).getName(), is("name1"));
    }

    @Test
    public void showNameTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("name1", "description1", 1);
        tracker.addItem(item);
        tracker.addItem(new Item("name2", "description2", 2));
        ArrayList<Item> result = new ArrayList<>();
        result.add(item);
        Input input = new StubInput(new String[] {"6", "name1", "0"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(result.size(), is(1));
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
        new StartUI(input, tracker, System.out::println).init();
        assertThat(find, is(result));
    }

    @Test
    public void editItemTest() {
        Tracker tracker = new Tracker();
        long id = System.currentTimeMillis();
        Item item = tracker.addItem(new Item("test name", "description", id));
        Input input = new StubInput(new String[]{
                "1", "test name", "description",
                "3", item.getId(), "test replace", "description",
                "0"});
        new StartUI(input, tracker, System.out::println).init();
        ArrayList<Item> result = tracker.findByName("test replace");
        assertThat(tracker.findByName("test replace"), is(result));
    }

    @Test
    public void delItemTest() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        Input input = new StubInput(
                new String[] {
                        "4",
                        String.valueOf(new Item("name1", "description1", 1)),
                        "0"
                }
        );
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findAll().size(), is(2));
    }
}