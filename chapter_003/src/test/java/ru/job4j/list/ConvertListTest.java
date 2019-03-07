package ru.job4j.list;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ConvertListTest {
    @Test
    public void whenListArraysToListTest() {
        List<int[]> list = new ArrayList<>();

        int[] array1 = {1, 2, 3, 4};
        list.add(array1);
        int[] array2 = {10, 20};
        list.add(array2);
        int[] array3 = {100, 200, 300};
        list.add(array3);

        ConvertList convertList = new ConvertList();
        List<Integer> result = convertList.convert(list);
        Integer[] resultList = {1, 2, 3, 4, 10, 20, 100, 200, 300};
        assertThat(Arrays.asList(resultList), is(result));
    }
}