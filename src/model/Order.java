package model;

import java.util.ArrayList;
import java.util.List;

public class Order implements Comparable<Order>{
    private int idOrder;
    private String productName;
    private double price;
    private int quantity;
    private int idCustomer;

    public Order(int idOrder, String productName, double price, int quantity, int idCustomer) {
        this.idOrder = idOrder;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.idCustomer = idCustomer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setId(int id) {
        this.idOrder = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", idCustomer=" + idCustomer +
                '}';
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.getIdOrder(), other.getIdOrder());
    }
}
