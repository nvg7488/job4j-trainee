package ru.job4j.tracker;
/**
 * Класс Item.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
import java.util.ArrayList;
import java.util.List;
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public int getActionsLentgh() { return  this.actions.size(); }
    public void fillActions() {
        this.actions.add(new ItemAdd(1, "Add Item."));
        this.actions.add(new ItemUpdate(2, "Update Item."));
        this.actions.add(new ItemDelete(3, "Delete Item."));
        this.actions.add(new ItemFindById(4, "Find Item by ID."));
        this.actions.add(new ItemFindByName(5, "Find Item by Name."));
        this.actions.add(new ItemShowAll(6, "Show all Item."));
    }
    public void select(int key) { this.actions.get(key).execute(this.input, this.tracker); }
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}