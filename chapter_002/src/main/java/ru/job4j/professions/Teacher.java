package ru.job4j.professions;
/**
 * Класс Doctor.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Teacher extends Profession {
    /**
     * Конструктор профессии учитель.
     * @param name имя специалиста
     */
    Teacher(String name) {
        super(name, "Учитель");
    }

    /**
     * Геттер для "name".
     * @return имя специалиста
     */
    String getName() {
        return super.getName();
    }

    /**
     * Метод обучения ученика учителем.
     * @param student ученик
     */
    String teach(Man student) {
        return ("Учитель " + super.getName() + " обучает ученика " + student.getName() + ".");
    }
}