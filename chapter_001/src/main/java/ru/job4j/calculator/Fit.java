package ru.job4j.calculator;
/**
 * Класс для вычисления идеального веса человека.
 * @author иколай Говорухин (govoruchin_nv@mail.ru).
 */
public class Fit {
    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100.0) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110.0) * 1.15;
    }
}

