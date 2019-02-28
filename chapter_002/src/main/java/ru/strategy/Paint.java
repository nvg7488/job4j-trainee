package ru.job4j.strategy;
/** @author Николай Говорухин (govoruchin_nv@mail.ru) */
public class Paint {
    /**
     * Рисует фигуру в консоли.
     * @param shape конкретная фигура.
     */
    public void draw(Shape shape) {
        shape.pic();
    }
}