package ru.job4j.loop;
/**
 * Шахматная доска.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Board {
    /**
     * Шахматная доска.
     * @param width ширина доски.
     * @param height высота доски.
     * @return Строка.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if ((x + y) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
