package ru.job4j.strategy;
/**
 * Тест классов фигур.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ShapeTest {
    /** Тест создания квадрата. */
    @Test
    public void testSquare() {
        Square square = new Square();
        String result = square.pic();
        String expectedFigure = "*****\n*****\n*****\n*****\n*****\n";
        assertThat(result, is(expectedFigure));
    }

    /** Тест создания треугольника. */
    @Test
    public void testTriangle() {
        Triangle triangle = new Triangle();
        String result = triangle.pic();
        String expectedFigure = "   *   \n  ***  \n ***** \n*******\n";
        assertThat(result, is(expectedFigure));
    }
}