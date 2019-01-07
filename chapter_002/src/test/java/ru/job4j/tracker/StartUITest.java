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
                .append("Меню:\n")
                .append("\t1. создание новой заявки\n")
                .append("\t2. редактирование заявки\n")
                .append("\t3. удаление заявки\n")
                .append("\t4. поиск записи по ID\n")
                .append("\t5. поиск записи по имени\n")
                .append("\t6. показывает все имеющиеся заявки\n")
                .append("\t0. выход из программы\n")
        .toString();
    }

    /** Test метода StartUI.addItem. */
    @Test
    public void testAddItem() {
        tracker = new Tracker();
        new StartUI(new StubInput(new String[] {"1", "test name", "description", "0"}), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /** Test метода StartUI.editItem. */
    @Test
    public void testEditItem() {
        tracker = new Tracker();
        Item item = tracker.addItem(new Item("test name", "description", 0));
        StartUI startUI = new StartUI(new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "0"}), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    /** Test метода StartUI.delItem. */
    @Test
    public void testDelItem() {
        tracker = new Tracker();
        tracker.addItem(new Item("name1", "description1", 1));
        tracker.addItem(new Item("name2", "description2", 2));
        String deleteID = tracker.findAll()[0].getId();
        Input input = new StubInput(new String[] {"3", deleteID, "0"});
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
        StartUI start =  new StartUI(new StubInput(new String[] {"4", result.getId(), "0"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.menu +
                        "Item ID: " + result.getId() + "\n" +
                        "Name: id\n" +
                        "Description: description\n" +
                        this.menu +
                        "Выход из программы, пока!\n"
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
        StartUI start =  new StartUI(new StubInput(new String[] {"5", "name", "0"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.menu +
                        "Item ID: " + result1.getId() + "\n" +
                        "Name: name\n" +
                        "Description: description\n" +
                        "Item ID: " + result2.getId() + "\n" +
                        "Name: name\n" +
                        "Description: description\n" +
                        this.menu +
                        "Выход из программы, пока!\n"
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
        this.result = this.menu +
                "Item ID: " + result1.getId() + "\nName: name\nDescription: description\n" +
                "Item ID: " + result2.getId() + "\nName: id\nDescription: description\n" +
                "Item ID: " + result3.getId() + "\nName: name\nDescription: description\n" +
                this.menu +
                "Выход из программы, пока!\n";
        StartUI start =  new StartUI(new StubInput(new String[] {"6", "0"}), tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.result)
        );
    }

    /** Test Menu Exit */
    @Test
    public void testExit() {
        StartUI start =  new StartUI(new StubInput(new String[] {"0"}), new Tracker()).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(this.menu + "Выход из программы, пока!\n")
        );
    }
}
