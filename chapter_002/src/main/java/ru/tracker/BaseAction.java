package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public abstract class BaseAction implements UserAction {
    private int key;
    private String name;
    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() { return this.key; }
    @Override
    public String info() { return String.format("%s : %s", this.key, this.name); }
}