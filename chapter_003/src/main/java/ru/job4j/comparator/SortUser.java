package ru.job4j.comparator;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class SortUser {
    public int compare(final User left, final User right) {
        final int result = left.getName().compareTo(right.getName());
        return result != 0 ? result : Integer.compare(left.getAge(), right.getAge());
    }
    public List<User> sort(List<User> users) {
        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = user1.getName().compareTo(user1.getName());
                return result != 0 ? result : user1.getAge().compareTo(user2.getAge());
            }
        };
        users.sort(userComparator);
        return users;
    }
}
