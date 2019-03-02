package ru.job4j.professions;
/**
 * Класс Doctor.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Engineer extends Profession {
    /**
     * Конструктор профессии инженер.
     * @param name имя специалиста
     */
    Engineer(String name) { super(name, "Инженер"); }

    /**
     * Геттер для "name".
     * @return имя специалиста
     */
    String getName() { return super.getName(); }

    /**
     * Вложенный класс Home.
     */
    public class Home{
        /** Наименование здания. */
        private String home;
        /**
         * Конструктор здания.
         * @param home наименование здания
         */
        Home(String home) { this.home = home; }
        /**
         * Геттер для "name".
         * @return Наименование здания
         */
        String getName() { return this.home; }
    }

    /**
     * Метод проектирования инженером здания.
     * @param home здание
     */
    String build() {
        Home house = new Home("Дом");
        return ("Инженер " + super.getName() + " спроектировал здание " + house.getName() + ".");
    }
}