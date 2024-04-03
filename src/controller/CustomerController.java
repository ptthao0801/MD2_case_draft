package controller;

import controller.validation.CustomerValidation;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    List<Customer> customers = new ArrayList<>();
    CustomerValidation customerValidation = new CustomerValidation();
    public Customer add() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email;
        String phone;

        while (true){
            email = scanner.nextLine();
            if (customerValidation.emailValidation(email)){
                break;
            } else {
                System.out.println("INVALID EMAIL FORMAT. PLEASE RE-ENTER: ");
            }
        }

        System.out.println("Enter phone number: ");

        while (true){
            phone = scanner.nextLine();
            if (customerValidation.phoneValidation(phone)){
                break;
            } else {
                System.out.println("INVALID PHONE NUMBER FORMAT. PLEASE RE-ENTER: ");
            }
        }

        System.out.println("Enter location: ");
        String location = scanner.nextLine();
        Customer newCustomer = new Customer(name, email, phone, location);
        customers.add(newCustomer);
        System.out.println("ADDED SUCCESSFULLY!");

//        System.out.println(newCustomer);
        return newCustomer;
    }
}
