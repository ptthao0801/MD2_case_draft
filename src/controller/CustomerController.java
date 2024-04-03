package controller;

import controller.validation.ValidationTool;
import model.Customer;

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
        Customer newCustomer = new Customer(id, name, email, phone, location);
        customers.add(newCustomer);
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

    @Override
    public void display(){
        for (Customer customer:customers){
            System.out.println(customer);
        }
    }
}
