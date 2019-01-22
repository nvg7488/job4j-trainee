package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    @Before
    public void loadMem() { System.setOut(new PrintStream(this.mem)); }
    @After
    public void loadSys() { System.setOut(this.out); }
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}) );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(String.format("Please, enter validate data again!%n"))
        );
    }
    @Test
    public void whenNumberFormatException() {
        String input = "2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ValidateInput validate = new ValidateInput(new ConsoleInput());
        int[] range = new int[]{1, 2, 3};
        int i = Integer.valueOf(input);
        Assert.assertEquals(validate.ask("Question", range), i);
    }
}