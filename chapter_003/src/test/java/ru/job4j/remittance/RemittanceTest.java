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

        remittance.deleteAccountFromUser("ausweis", new Account(999000.09, 1980));
        assertThat(
                remittance.
                        getUserAccounts("ausweis").
                        remove(new Account(999000.09, 1980)),
                is(false)
        );
    }

    @Test
    public void testTransferMoney() {
        Remittance remittance = new Remittance();

        User user1 = new User("name1", "passport1");
        remittance.addUser(user1);
        Account account11 = new Account(12000.00, 1);
        Account account12 = new Account(4000.00, 2);
        Account account13 = new Account(5000.00, 3);
        remittance.addAccountToUser("passport1", account11);
        remittance.addAccountToUser("passport1", account12);
        remittance.addAccountToUser("passport1", account13);

        User user2 = new User("name2", "passport2");
        remittance.addUser(user2);
        Account account21 = new Account(10000.00, 1);
        Account account22 = new Account(8000.00, 2);
        Account account23 = new Account(3000.00, 3);
        remittance.addAccountToUser("passport2", account21);
        remittance.addAccountToUser("passport2", account22);
        remittance.addAccountToUser("passport2", account23);

        remittance.transferMoney("passport1", 1, "passport2", 3, 2000);

        Account testAcc = new Account(12000.00, 1);
        testAcc.withdraw(2000);
        assertThat(remittance.getUserAccounts("passport1").get(0).getValue(), is(testAcc.getValue()));

        testAcc = new Account(3000.00, 3);
        testAcc.deposit(2000);
        assertThat(remittance.getUserAccounts("passport2").get(2).getValue(), is(testAcc.getValue()));
    }
}
