package ru.job4j.comparator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.contains;
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
    @Test
    public void UserTest() {
        List<User> users = new ArrayList<>();
        User user1 = new User("name", 25);
        users.add(user1);
        User user2 = new User("longname", 30);
        users.add(user2);
        User user3 = new User("longname", 35);
        users.add(user3);
        User user4 = new User("name", 30);
        users.add(user4);
        new SortUser().sort(users);
//        assertThat(users, contains(user2, user4, user1, user3));
        assertThat(users, contains(user2, user3, user1, user4));
    }
}
