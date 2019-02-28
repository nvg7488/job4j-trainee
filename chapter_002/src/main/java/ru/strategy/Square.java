package ru.job4j.strategy;
/**
 * Класс Квадрат.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Square implements Shape {
    /**
     * Метод для рисования квадрата.
     * @return квадрат в консоли.
     */
    public String pic() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("*****");
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}