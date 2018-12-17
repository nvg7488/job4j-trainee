package ru.job4j.professions;
/**
 * Класс Profession.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Profession {
    /** Имя специалиста. */
    private String name;
    /** Название профессии. */
    private String profession;

    /**
     * Конструктор профессии.
     * @param name       имя
     * @param profession профессия
     */
    Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Зеттер для "name".
     * @param name специалиста
     */
    void setName(String name) { this.name = name; }
    /**
     * Зеттер для "profession".
     * @param profession название профессии
     */
    void setProfession(String profession) { this.profession = profession; }
    /**
     * Геттер для "name".
     * @return имя специалиста
     */
    String getName() { return name; }
    /**
     * Геттер для "profession".
     * @return название профессии
     */
    String getProfession() { return profession; }
}