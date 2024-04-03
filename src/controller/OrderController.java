package controller;

import controller.validation.ValidationTool;
import model.Customer;
import model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static controller.validation.ValidationTool.emailValidation;
import static controller.validation.ValidationTool.phoneValidation;

public class OrderController implements Action, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Order> orders = new ArrayList<>();
    @Override
    public void display() {
        Collections.sort(orders);
        for (Order order:orders){
            System.out.println(order);
        }
    }

    @Override
    public void add() {
        System.out.println("Enter ID: ");
        int id;
        while (true){
            id = Integer.parseInt(scanner.nextLine());
            if (ValidationTool.idValidation(id)){
                break;
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

    }

    @Override
    public void search() {

    }

    @Override
    public void writeToFile() {

    }

    @Override
    public void readFromFile() {

    }

}
