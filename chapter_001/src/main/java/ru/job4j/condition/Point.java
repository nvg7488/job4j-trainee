package ru.job4j.condition;
/**
 * Класс точки в системе координат.
 * @author Николай Говорухин (govoruchin_nv@mail.ru).
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор.
     * @param x x
     * @param y y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method distanceTo.
     * @param that that
     * @return sqrt
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
            Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}