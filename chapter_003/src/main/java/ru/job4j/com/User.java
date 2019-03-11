package ru.job4j.com;
import java.util.Objects;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class User {
    private int age;
    private String name;
    private String city;
    public User(int age, String name, String city) {
        this.age = age;
        this.name = name;
        this.city = city;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}