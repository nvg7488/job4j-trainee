package ru.job4j.user;
import java.util.HashMap;
import java.util.List;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}