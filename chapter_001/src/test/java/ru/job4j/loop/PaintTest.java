package ru.job4j.loop;
import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test класса построения пирамиды в псевдографике.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class PaintTest {
    /**
     * Test построения правой части пирамиды.
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        assertThat(rst,
            is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("^   ")
                    .add("^^  ")
                    .add("^^^ ")
                    .add("^^^^")
                    .toString()
                )
        );
    }

    /**
     * Test построения левой части пирамиды.
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        assertThat(rst,
            is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("   ^")
                    .add("  ^^")
                    .add(" ^^^")
                    .add("^^^^")
                    .toString()
                )
        );
    }

    /**
     * Test построения всей пирамиды.
     */
    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        assertThat(rst,
            is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("   ^   ")
                    .add("  ^^^  ")
                    .add(" ^^^^^ ")
                    .add("^^^^^^^")
                    .toString()
            )
        );
    }
}