package model;

public abstract class Store {
    private int id;
    private final String name = "ZARA";
    public Store() {
    }
    public Store(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void greeting(){}
}
