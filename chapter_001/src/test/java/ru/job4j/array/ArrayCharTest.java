package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test метода, проверябщего, что слово начинается в определенной последовательности.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ArrayCharTest {
    /**
     * Test whenStartWithPrefixThenTrue
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Test whenNotStartWithPrefixThenFalse
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}