package ru.job4j.comparator;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }
}
