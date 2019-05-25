package ru.job4j.tracker;
/**
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long create;

    Item(String name, String description, long create) {
        this.name = name;
        this.create = create;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreate(long create) {
        this.create = create;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public long getCreate() {
        return this.create;
    }

    public void printInfo() {
        System.out.println(
                String.format("Item ID: %s\nName: %s\nDescription: %s",
                this.getId(), this.getName(), this.getDescription())
        );
    }
}