package ru.job4j.comparator;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class SortUser {
    public int compare(final User left, final User right) {
        final int result = left.getName().compareTo(right.getName());
        return result != 0 ? result : Integer.compare(left.getAge(), right.getAge());
    }

}
