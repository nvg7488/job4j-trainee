package ru.job4j.user;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import ru.job4j.user.User;
import ru.job4j.user.UserConvert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserConvertTest {
    @Test
    public void convertUserListToMapTest() {
        User user1 = new User(1, "name1", "city1");
        User user2 = new User(2, "name2", "city2");
        User user3 = new User(3, "name3", "city3");
        User user4 = new User(4, "name4", "city4");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        HashMap<Integer, User> process = new UserConvert().process(users);
        int size = 4;
        assertThat(process.size(), is(size));
    }
}