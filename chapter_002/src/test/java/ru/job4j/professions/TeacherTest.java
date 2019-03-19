package ru.job4j.professions;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Teacher .
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class TeacherTest {
    /** Проверка что учитель обучает ученика. */
    @Test
    public void testTeach() {
        Teacher professional = new Teacher("Говорухин");
        Man student = new Man("Николай", 16);
        String expectString = "Учитель Говорухин обучает ученика Николай.";
        assertThat(professional.teach(student), is(expectString));
        assertThat(professional.getName(), is("Говорухин"));
    }
}