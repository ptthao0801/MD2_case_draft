package model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String category;

    private double totalValueByProductId;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Product(int id, double totalValueByProductId) {
        this.id = id;
        this.totalValueByProductId = totalValueByProductId;
    }

    public Product(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalValueByProductId() {
        return totalValueByProductId;
    }

    public void setTotalValueByProductId(double totalValueByProductId) {
        this.totalValueByProductId = totalValueByProductId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
