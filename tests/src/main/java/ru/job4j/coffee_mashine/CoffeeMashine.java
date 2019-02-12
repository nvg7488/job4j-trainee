package ru.job4j.coffee_mashine;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class CoffeeMashine {
    public int[] changes(int value, int price) {
        List<Integer> rez = new ArrayList<>();
        int index = 0;
        int money [] = new int[] {10, 5, 2, 1};
        value -= price;
        do {
            for(int cash : money) {
                if(value >= cash) {
                    rez.add(index++, cash);
                    value -= cash;
                    break;
                }
            }
        } while (value > 0);
        int rezult[] = new int[rez.size()];
        for(index = 0; index < rez.size(); index++) { rezult[index] = rez.get(index); }
        return rezult;
    }
}