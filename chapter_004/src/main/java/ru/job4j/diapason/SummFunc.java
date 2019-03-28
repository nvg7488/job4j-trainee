package ru.job4j.diapason;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
public class SummFunc {
    public static List<Double> diapason(int first, int last, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = first; index < last; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
