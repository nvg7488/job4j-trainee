package ru.job4j.professions;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Teacher .
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class testGetSet {
    @Test
    public void testMan() {
        Man man = new Man(" ", 0);
        man.setName("Name");
        man.setAge(144);
        assertThat(man.getAge(), is(144));
    }

    @Test
    public void testProfession() {
        Profession profession = new Profession(" ", " ");
        profession.setName("Name");
        profession.setProfession("Profession");
        assertThat(profession.getProfession(), is("Profession"));
    }
}