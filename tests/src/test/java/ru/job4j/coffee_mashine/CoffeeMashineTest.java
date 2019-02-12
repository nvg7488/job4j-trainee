package ru.job4j.coffee_mashine;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMashineTest {
    /** Тест сдачи 15 р с полтинника. */
    @Test
    public void testChanges35() {
        CoffeeMashine mashine = new CoffeeMashine();
        int[] expect = new int[] {10, 5};
        assertThat(mashine.changes(50, 35), is(expect));
    }
    /** Тест сдачи 14 р с полтинника. */
    @Test
    public void testChanges36() {
        CoffeeMashine mashine = new CoffeeMashine();
        int[] expect = new int[] {10, 2, 2};
        assertThat(mashine.changes(50, 36), is(expect));
    }
    /** Тест сдачи 16 р с полтинника. */
    @Test
    public void testChanges34() {
        CoffeeMashine mashine = new CoffeeMashine();
        int[] expect = new int[] {10, 5, 1};
        assertThat(mashine.changes(50, 34), is(expect));
    }
}