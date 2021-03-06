package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import java.util.Objects;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserAccountTest {
    @Test
    public void userTest() {
        User user = new User("govoruchin_nv", "ausweis");
        int hash = user.hashCode();
        assertThat(user.hashCode(), is(hash));
        assertThat(user.equals(user), is(true));
    }
    @Test
    public void accountTest() {
        Account account  = new Account(999000.09, 7488);
        assertThat(account.getValue(), is(999000.09));
        assertThat(account.getRequisites(), is(7488L));
    }
}