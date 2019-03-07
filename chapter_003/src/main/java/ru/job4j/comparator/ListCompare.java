package ru.job4j.comparator;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.Comparator;
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        int result = 0;
        for (int index = 0; index < str1.length(); index++) {
            result = Character.compare(str1.charAt(index), str2.charAt(index));
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? 0 : Integer.compare(str1.length(), str2.length());
    }
}
