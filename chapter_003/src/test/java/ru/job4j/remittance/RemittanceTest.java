package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RemittanceTest {
    @Test
    public void testUserAddDelete() {
        Remittance remittance = new Remittance();
        User user = new User("govoruchin_nv", "ausweis");
        remittance.addUser(user);
        assertThat(remittance.sizeUser(), is(1));
        remittance.deleteUser(user);
        assertThat(remittance.sizeUser(), is(0));
    }

    @Test
    public void testAccountAdd() {
        Remittance remittance = new Remittance();
        User user = new User("govoruchin_nv", "ausweis");
        remittance.addUser(user);
        remittance.addAccountToUser("ausweis", new Account(999000.09, 7488));
        remittance.addAccountToUser("ausweis", new Account(999000.09, 1980));
        assertThat(
                remittance.
                        getUserAccounts("ausweis").
                        add(new Account(999000.09, 7488)),
                is(true)
        );
    }
}
