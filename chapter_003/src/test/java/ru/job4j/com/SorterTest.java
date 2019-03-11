package ru.job4j.com;

import org.junit.Test;
//import java.util.Comparator;
import java.util.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SorterTest {
    @Test
    public void sortTest() {
        List<User> list = new ArrayList<>();
        list.add(new User(2, "name2", "city2"));
        list.add(new User(1, "name1", "city1"));
        list.add(new User(3, "name3", "city3"));
        List<User> result = new ArrayList<>();
        result.add(new User(1, "name1", "city1"));
        result.add(new User(2, "name2", "city2"));
        result.add(new User(3, "name3", "city3"));
        assertThat(new Sorter().sort(list), is(result));
    }
}