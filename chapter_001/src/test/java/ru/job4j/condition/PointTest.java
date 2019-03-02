package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода класса точки в системе координат.
 * @author Николай Говорухин (govoruchin_nv@mail.ru).
 */
public class PointTest {
    /**
     * Test distanceToTest
     */
    @Test
    public void distanceToTest() {
        Point a = new Point(0, 3);
        Point b = new Point(4, 0);
        assertThat(a.distanceTo(b), is(5D));
    }
}
