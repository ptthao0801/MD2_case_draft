package model;

import java.io.Serializable;

public abstract class Store implements Serializable {
    private int id;
    public final String name = "ZARA";
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

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
