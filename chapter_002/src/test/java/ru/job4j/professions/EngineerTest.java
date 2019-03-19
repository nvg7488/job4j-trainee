package ru.job4j.professions;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Engineer.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class EngineerTest {
    /** Проверка что инженер проектирует здание. */
    @Test
    public void testEngineer() {
        Engineer engineer = new Engineer("Говорухин");
        String expectString = "Инженер Говорухин спроектировал здание Дом.";
        assertThat(engineer.build(), is(expectString));
        assertThat(engineer.getName(), is("Говорухин"));
    }
}