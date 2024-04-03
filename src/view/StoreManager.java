package view;

import controller.CustomerController;
import controller.OrderController;
import model.Customer;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerController customer = new CustomerController();
        OrderController order = new OrderController();


        // thuc thi customer
        customer.add();
//        customer.display();


        // thuc thi Order

//        for (int i = 0; i < 1; i++) {
//            order.add();
//        }
//        order.display();
//        order.search();
//        order.display();

    }
}
