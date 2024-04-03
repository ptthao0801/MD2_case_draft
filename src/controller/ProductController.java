package controller;

import controller.validation.ValidationTool;
import model.Action;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController implements Action, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();

    @Override
    public void display() {
        System.out.println("------DISPLAY------");
        for (Product product:products){
            System.out.println(product);
        }
    }

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
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        String category = scanner.nextLine();
        Product newProduct = new Product(id,name,category);
        products.add(newProduct);
        System.out.println("ADDED SUCCESSFULLY!");
        System.out.println(newProduct);
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Product product:products){
                if (product.getId()==id){
                    isAvailable = true;
                    products.remove(product);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("PRODUCT ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("PRODUCT ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH------");
        System.out.println("Enter ID or Name: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Product product: products) {
            if (String.valueOf(product.getId()).equals(searchItem) || product.getName().equalsIgnoreCase(searchItem)) {
                System.out.println("FOUND! " + product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("PRODUCT NOT FOUND!");
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
