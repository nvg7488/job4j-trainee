package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestItemAdd {
    @Test
    public void testItemAdd() {
        ItemAdd add = new ItemAdd(0, "Name");
        assertThat(add.key(), is(0));
        assertThat(add.info(), is("0, Name"));

        
    }
}