package controller;

import controller.validation.ValidationTool;
import model.Customer;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static controller.validation.ValidationTool.emailValidation;
import static controller.validation.ValidationTool.phoneValidation;

public class CustomerController implements Action {
    Scanner scanner = new Scanner(System.in);
    List<Customer> customers = new ArrayList<>();
    @Override
    public void add() {
        System.out.println("------ADD------");
        System.out.println("Enter ID: ");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (ValidationTool.idValidation(id)) {
                    break;
                } else {
                    System.out.println("ID must be a positive number. Please re-enter: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. ID must be a number. Please re-enter: ");
            }
        }


        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter email address: ");
        String email;
        while (true){
            email = scanner.nextLine();
            if (emailValidation(email)){
                break;
            } else {
                System.out.println("INVALID EMAIL FORMAT. PLEASE RE-ENTER: ");
            }
        }

        System.out.println("Enter phone number: ");
        String phone;
        while (true){
            phone = scanner.nextLine();
            if (phoneValidation(phone)){
                break;
            } else {
                System.out.println("INVALID PHONE FORMAT. PLEASE RE-ENTER: ");
            }
        }

        System.out.println("Enter location: ");
        String location = scanner.nextLine();
        Customer newCustomer = new Customer(id,name,email,phone,location);
        customers.add(newCustomer);
        System.out.println("ADDED SUCCESSFULLY!");
        System.out.println(newCustomer);
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Customer customer:customers){
                if (customer.getId()==id){
                    isAvailable = true;
                    customers.remove(customer);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("CUSTOMER ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("CUSTOMER ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH------");
        System.out.println("Enter ID or Name: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Customer customer: customers) {
            if (String.valueOf(customer.getId()).equals(searchItem) || customer.getName().equalsIgnoreCase(searchItem)) {
                System.out.println("FOUND! " + customer);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("CUSTOMER NOT FOUND!");
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

    @Override
    public void display(){
        System.out.println("------DISPLAY------");
        for (Customer customer:customers){
            System.out.println(customer);
        }
    }
}
