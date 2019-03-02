package ru.job4j.professions;
/**
 * Класс Doctor.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Doctor extends Profession {
    /**
     * Конструктор профессии доктор.
     * @param name имя специалиста
     */
    Doctor(String name) { super(name, "Доктор"); }

    /**
     * Геттер для "name".
     * @return имя специалиста
     */
    String getName() { return super.getName(); }

    /**
     * Метод лечения пациента доктором.
     * @param pacient пациент
     */
    String heal(Man pacient) { return ("Доктор " + super.getName() + " лечит пациента " + pacient.getName() + "."); }
}