package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

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
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

//    private void showId() {
//        String idToShow = input.ask("Введите ID записи, подлежащей просмотра: ");
//        if (tracker.findById(idToShow) == null) {
//            System.out.println("Запись с введённым ID не существует.");
//        } else {
//            tracker.findById(idToShow);
//        }
//    }

//    private void showName() {
//        String nameToShow = input.ask("Введите Name записи, подлежащей просмотра: ");
//        if (tracker.findByName(nameToShow) == null) {
//            System.out.println("Запись с введённым именем не существует.");
//        } else {
//            tracker.findByName(nameToShow);
//        }
//    }

//    private void showAllItem() {
//        if (tracker.getSize() == 0) {
//            System.out.println("Tracker пустой!");
//        } else {
//            for (Item item : tracker.findAll()) {
//                System.out.println();
//                item.printInfo();
//            }
//        }
//    }

//    private void editItem() {
//        String idToEdit = input.ask("Введите ID записи, подлежащей редактированию: ");
//        if (tracker.findById(idToEdit) == null) {
//            System.out.println("Запись с введённым ID не существует.");
//        } else {
//            String newName = input.ask("Введите новой имя для редактируемой записи: ");
//            String newDescription = input.ask("Введите новое описание для редактируемой записи: ");
//            Item item = new Item(newName, newDescription, System.currentTimeMillis());
//            item.setId(idToEdit);
//            tracker.update(item);
//        }
//    }

//    private void delItem() {
//        String idToEdit = input.ask("Введите ID записи, подлежащей удалению: ");
//        if (tracker.findById(idToEdit) == null) {
//            System.out.println("Запись с введённым ID не существует.");
//        } else {
//            tracker.delete(tracker.findById(idToEdit));
//        }
//    }

//    private void showMenu() {
//        System.out.println("Меню:");
//        System.out.println("\t1. создание новой заявки");
//        System.out.println("\t2. показывает все имеющиеся заявки");
//        System.out.println("\t3. редактирование заявки");
//        System.out.println("\t4. удаление заявки");
//        System.out.println("\t0. выход из программы");
//    }
}