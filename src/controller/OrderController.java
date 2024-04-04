package controller;

import controller.validation.ValidationTool;
import model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderController implements ActionForModel, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Order> orders = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("------DISPLAY ORDER------");
        Collections.sort(orders);
        for (Order order:orders){
            System.out.println(order);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD ORDER------");
        System.out.println("Enter ID: ");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (ValidationTool.idValidation(id)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. ID must be a number. Please re-enter: ");
            }
        }
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price;
        while (true) {
            price = Double.parseDouble(scanner.nextLine());
            if (ValidationTool.priceValidation(price)){
                break;
            }
        }
        System.out.println("Enter quantity: ");
        int quantity;
        while (true) {
            quantity = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.quantityValidation(quantity)){
                break;
            }
        }
        System.out.println("Enter ID Customer: ");
        int idCustomer;
        while (true) {
            idCustomer = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.quantityValidation(idCustomer)){
                break;
            }
        }
        Order newOrder = new Order(id, name, price, quantity,idCustomer);
        orders.add(newOrder);
        System.out.println("ADDED SUCCESSFULLY!");
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE ORDER------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Order order:orders){
                if (order.getIdOrder()==id){
                    isAvailable = true;
                    orders.remove(order);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("ORDER ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("ORDER ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH ORDER------");
        System.out.println("Enter ID or Name: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Order order : orders) {
            if (String.valueOf(order.getIdOrder()).equals(searchItem) || order.getProductName().equalsIgnoreCase(searchItem)) {
                System.out.println("FOUND! " + order);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("ORDER NOT FOUND!");
        }
    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");

    }

    @Override
    public void readFromFile() {
        System.out.println("------READ FROM FILE------");

    }

}
