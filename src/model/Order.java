package model;

import java.util.ArrayList;
import java.util.List;

public class Order implements Comparable<Order>{
    private int idOrder;
    private double price;
    private int quantity;
    private int idCustomer;
    private int idProduct;

    public Order(int idOrder, double price, int quantity, int idCustomer, int idProduct) {
        this.idOrder = idOrder;
        this.price = price;
        this.quantity = quantity;
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
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

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", price=" + price +
                ", quantity=" + quantity +
                ", idCustomer=" + idCustomer +
                ", idProduct=" + idProduct +
                '}';
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.getIdOrder(), other.getIdOrder());
    }
}
