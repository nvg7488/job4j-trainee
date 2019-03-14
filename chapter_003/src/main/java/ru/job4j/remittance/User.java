package ru.job4j.remittance;
import java.util.Objects;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class User {
    private String name;
    private String passport;
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object object) {
        boolean result;
        if (this == object) result = true;
        if (object == null || getClass() != object.getClass()) result = false;
        User user = (User) object;
        result = name.equals(user.name) && passport.equals(user.passport);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}