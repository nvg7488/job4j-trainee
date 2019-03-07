package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if (pers.getName().contains(key) || pers.getSurname().contains(key) || pers.getPhone().contains(key) || pers.getAddress().contains(key)) {
                result.add(pers);
            }
        }
        return result;
    }
}