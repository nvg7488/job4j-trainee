package ru.job4j.list;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x : array) {
            for (int y : x) {
                list.add(y);
            }
        }
        return list;
    }
}