package ru.job4j.list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ConvertList {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array: list) {
            for (int item : array) {
                result.add(item);
            }
        }
        return result;
    }
}