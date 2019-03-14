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
    public boolean equals(Object user) {
        return (this == user);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}