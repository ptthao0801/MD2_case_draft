package controller;

import controller.validation.ValidationTool;
import model.Customer;
import model.Order;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController implements ActionForModel, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    String path = "product.txt";

    public ProductController(){
        products.add(new Product(1, "Apple","bycicle"));
        products.add(new Product(2, "Electrolux","phone"));
        products.add(new Product(3, "Toshiba","fridge"));
        products.add(new Product(4, "Sharp","TV"));
        products.add(new Product(5, "LG","laptop"));
    }

    @Override
    public void display() {
        System.out.println("------DISPLAY PRODUCT------");
        for (Product product:products){
            System.out.println(product);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD PRODUCT------");
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
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Category: ");
        String category = scanner.nextLine();
        Product newProduct = new Product(id,name,category);
        products.add(newProduct);
        System.out.println("ADDED SUCCESSFULLY!");
        System.out.println(newProduct);
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE PRODUCT------");
        System.out.println("Remove this ID: ");
        boolean exit = false;
        while (!exit){
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
                exit = true;
            } else {
                System.out.println("PRODUCT ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH PRODUCT------");
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
    public void getNameById(int id){
        for (Product product: products) {
            if (product.getId() == id) {
                System.out.println("FOUND! " + product);
            } else {
                System.out.println("PRODUCT NOT FOUND!");
            }
        }
    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");
        ObjectOutputStream oos = null;
        String path = "product.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Product product : products) {
                oos.writeObject(product);
            }
            fos.close();
            oos.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE WRITING TO FILE "+ path);
    }

//    @Override
    public void readFromFile() {
        System.out.println("------READ FROM FILE------");
        List<Product> readProducts = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Product product = (Product) ois.readObject();
                    if (product != null) {
                        readProducts.add(product);
                    } else {
                        break;
                    }
                } catch (EOFException e) {
                    // Đọc đến cuối file
                    break;
                }
            }
            System.out.println("DONE READING FROM FILE " + path);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        List<Product> productDataFromFile = readProducts;
        for (Product product : productDataFromFile){
            System.out.println(product);
        }
    }
    public List<Product> getProductList() {
        return products;
    }
}
