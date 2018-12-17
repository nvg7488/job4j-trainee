package ru.job4j.tracker;
/**
 * Класс Item.
 * @author Николай Говорухин (govoruchin_nv@mail.ru)
 */
class Item {
    /** Уникальный id заявки */
    private String id;
    /** Не уникальное наименование заявки */
    private String name;
    /** Не уникальное описание заявки */
    private String description;
    /** Время добавления заявки */
    private long create;
//    /** комментарии */
//    private String[] comments = new String[100];

    /**
     * Конструктор Item.
     * @param name        наименование заявки
     * @param description описание заявки
     * @param create      время добавления заявки
     */
    Item(String name, String description, long create) {
        this.name = name;
        this.create = create;
        this.description = description;
    }

    public void setId(String id) { this.id = id; }
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public long getCreate() { return this.create; }

    /** Вывод на экран информации об элементе. */
    public void printInfo() { System.out.println(String.format("Item ID: %s\nName: %s\nDescription: %s", this.getId(), this.getName(), this.getDescription())); }
}