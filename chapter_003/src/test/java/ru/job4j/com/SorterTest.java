package ru.job4j.com;

import org.junit.Test;
import java.util.*;
import ru.job4j.user.User;
import java.util.Comparator;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SorterTest {
//    @Test
//    public void sortTest() {
//        List<User> list = new ArrayList();
//        list.add(new User(2, "name2", "city2"));
//        list.add(new User(1, "name1", "city1"));
//        list.add(new User(3, "name3", "city3"));
//        Sorter sorter = new Sorter();
//
//        Set<User> result = (Set<User>) new ArrayList();
//        result.add(new User(1, "name1", "city1"));
//        result.add(new User(2, "name2", "city2"));
//        result.add(new User(3, "name3", "city3"));
//
//        assertThat(sorter.sort(list), is(result));
//    }

//    List<User> sortnamelength(List<User> list) {    //  sortNameLength
//        Comparator<User> compar = new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getName().length() - o2.getName().length();
//            }
//        };
//        list.sort(compar);
//        return list;

//    List<User> sortboth(List<User> list) {  //  sortBoth
//        Comparator<User> compar1 = new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//        Comparator<User> compar2 = new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        list.sort(compar1.thenComparing(compar2));
//        return list;
}