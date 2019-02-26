package ru.job4j.comparator;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class SortUserTest {
    @Test
    public void SortTest() {
        assertThat(
                new SortUser().compare(
                        new User("Name", 20),
                        new User("Name", 30)
                ), is(-1)
        );
    }
}
