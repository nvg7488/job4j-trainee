package ru.job4j.com;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertTest {
    @Test
    public void makeListTest() {
        int[][] array = {{1, 2}, {3, 4}};
        Convert convert = new Convert();
        assertThat(convert.makeList(array).size(), is(4));
    }

//    public int[][] makeArray(List<Integer> list, int rws) {
//        Iterator<Integer> iterator = list.iterator();
//        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);
//
//
//        int[][] array = new int[rws][cls];
//        for (int i = 0; i < rws; i++) {
//            for (int j = 0; j < cls; j++) {
//                if (iterator.hasNext()) {
//                    array[i][j] = iterator.next();
//                } else {
//                    array[i][j] = 0;
//                }
//            }
//        }
//        return array;
//    }
}
