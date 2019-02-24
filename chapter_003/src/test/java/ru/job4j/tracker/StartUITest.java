package ru.job4j.tracker;
/**
 * Тесты методов класса StartU.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public  class StartUITest {
    private Tracker tracker;
    private String menu;
    private String result;
    // буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void SetMenu() {
        System.setOut(new PrintStream(out));
        this.menu = new StringBuilder()
                .append("0, Add Item.\n")
                .append("1, Update Item.\n")
                .append("2, Delete Item.\n")
                .append("3, Find Item by ID.\n")
                .append("4, Find Item by Name.\n")
                .append("5, Show all Item.\n")
        .toString();
    }

    /** Test метода StartUI.addItem. */
    @Test
    public void testAddItem() {
        tracker = new Tracker();
        new StartUI(new StubInput(new String[] {"0", "test name", "description", "y"}), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /** Test метода StartUI.editItem. */
    @Test
    public void testEditItem() {
        tracker = new Tracker();
        Item item = tracker.addItem(new Item("test name", "description", 0));
        StartUI startUI = new StartUI(new StubInput(new String[]{"1", item.getId(), "test replace", "заменили заявку", "y"}), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    /** Test метода StartUI.delItem. */
    @Test
    public void testDelItem() {
        tracker = new Tracker();
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        String deleteID = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"2", deleteID, "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("name2"));
    }

    /** Test Print Items ID */
    @Test
    public void testPrintItemID() {
        tracker = new Tracker();
        Item result = new Item("id", "description", 0);
        tracker.addItem(result);
        tracker.addItem(new Item("name", "description1", 1));
        tracker.addItem(new Item("name", "description2", 2));
        StartUI start =  new StartUI(new StubInput(new String[] {"3", result.getId(), "y"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.menu
                        + "Item ID: " + result.getId() + "\n"
                        + "Name: id\n"
                        + "Description: description\n"
                )
        );
    }

    /** Test Print Items Name */
    @Test
    public void testPrintItemName() {
        tracker = new Tracker();
        tracker.addItem(new Item("id", "description", 0));
        Item result1 = new Item("name", "description", 1);
        tracker.addItem(result1);
        Item result2 = new Item("name", "description", 2);
        tracker.addItem(result2);
        StartUI start =  new StartUI(new StubInput(new String[] {"4", "name", "y"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.menu
                        + "Item ID: " + result1.getId() + "\n"
                        + "Name: name\n"
                        + "Description: description\n"
                        + "Item ID: " + result2.getId() + "\n"
                        + "Name: name\n"
                        + "Description: description\n"
                )
        );
    }

    /** Test Print All Items */
    @Test
    public void testPrintAllItems() {
        tracker = new Tracker();
        Item result1 = new Item("name", "description", 1);
        tracker.addItem(result1);
        Item result2 = new Item("id", "description", 2);
        tracker.addItem(result2);
        Item result3 = new Item("name", "description", 3);
        tracker.addItem(result3);
        this.result = this.menu
                + "Item ID: " + result1.getId() + "\nName: name\nDescription: description\n"
                + "Item ID: " + result2.getId() + "\nName: id\nDescription: description\n"
                + "Item ID: " + result3.getId() + "\nName: name\nDescription: description\n";
        StartUI start =  new StartUI(new StubInput(new String[] {"5", "y"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.result)
        );
    }
}