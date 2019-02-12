package ru.job4j.coffee_mashine;
import java.util.Arrays;
/**
 * Тестовая задача: кофе-машина.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Start {
    public static int main(String[] args) {
        CoffeeMashine mashine = new CoffeeMashine();
        int cash[] = mashine.changes(50, 35);
        System.out.println(Arrays.toString(cash));
    return 0; }
}