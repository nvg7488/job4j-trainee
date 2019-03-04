package ru.job4j.strategy;
/**
 * Класс Треугольник.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Triangle implements Shape {
    /**
     * Метод для рисования треугольника.
     * @return треугольник в консоли.
     */
    public String pic() {
        String ls = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("   *   " + ls);
        sb.append("  ***  " + ls);
        sb.append(" ***** " + ls);
        sb.append("*******" + ls);
        return sb.toString();
    }
}