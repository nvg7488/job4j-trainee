package ru.job4j.professions;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Doctor .
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class DoctorTest {
    /** Проверка что доктор лечит пациента. */
    @Test
    public void testHeal() {
        Doctor doc = new Doctor("Говорухин");
        Man pacient = new Man("Николай", 144);
        String expectString = "Доктор Говорухин лечит пациента Николай.";
        assertThat(doc.heal(pacient), is(expectString));
    }
}