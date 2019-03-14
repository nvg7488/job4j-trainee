package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemittanceTest {
    @Test
    public void addUserTest() {
        Remittance remittance = new Remittance();
        User user = new User("govoruchin_nv", "ausweis");
        remittance.addUser(user);
        assertThat(remittance.sizeUser(), is(1));
    }
}
