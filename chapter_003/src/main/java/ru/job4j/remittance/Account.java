package ru.job4j.remittance;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Account {
    /**   сумма   */
    private double value;
    /**   реквизиты   */
    private long requisites;
    public Account(double value, long requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    public long getRequisites() {
        return this.requisites;
    }
    public boolean checkValue(double amount) {
        return (this.value >= amount);
    }
    public void withdraw(double amount) {
        this.value -= amount;
    }
    public void deposit(double amount) {
        this.value += amount;
    }

    public double getValue() {
        return this.value;
    }
}