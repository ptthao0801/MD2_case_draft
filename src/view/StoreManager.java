package view;

import controller.CustomerController;

import java.util.Scanner;

public class StoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerController customer = new CustomerController();

        customer.add();

    }
}
