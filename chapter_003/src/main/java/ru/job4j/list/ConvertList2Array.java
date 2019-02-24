package ru.job4j.list;
import java.util.Arrays;
import java.util.List;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double)list.size() / (double)rows);
        int[][] array = new int[rows][cells];
        int x = 0, y = 0;
        for (Integer index : list) {
            array[x][y++] = index;
            if (y ==  array[x].length) {
                y = 0;
                x++;
            }
        }
        return array;
    }
}