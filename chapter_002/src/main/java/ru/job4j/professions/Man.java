package ru.job4j.professions;
/**
 * Класс Man.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Man {
    /** Имя человека. */
    private String name;
    /** Возраст человека. */
    private int age;

    /**
     * Конструктор человека.
     * @param name имя
     * @param age  возраст
     */
    Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Зеттер для "name".
     * @param name имя человека
     */
    void setName(String name) { this.name = name; }
    /**
     * Зеттер для "age".
     * @param age возраст человека
     */
    void setAge(int age) { this.age = age; }
    /**
     * Геттер для "name".
     * @return имя человека
     */
    String getName() { return this.name; }
    /**
     * Геттер для "age".
     * @return возраст человека
     */
    int getAge() { return this.age; }
}