package ru.job4j.com;

import org.junit.Test;
import java.util.ArrayList;
//import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertTest {
    @Test
    public void makeListTest() {
        int[][] array = {{0, 0}, {0, 0}};
        Convert convert = new Convert();
        assertThat(convert.makeList(array).size(), is(4));
    }
    @Test
    public void makeArrayTest() {
        int[][] array = {{0, 0}, {0, 0}};
        ArrayList<Integer> list = new ArrayList();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        Convert convert = new Convert();
        assertThat(
                convert.makeArray(list, 2),
                is(array)
        );
    }
}