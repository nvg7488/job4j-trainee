package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import java.util.Objects;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void equalsTest() {
        User user = new User("govoruchin_nv", "ausweis");
        assertThat(user.equals(user), is(true));
    }

    @Test
    public void hashCodeTest() {
        User user = new User("govoruchin_nv", "ausweis");
        int hash = user.hashCode();
        assertThat(user.hashCode(), is(hash));
    }
}