package controller;

import controller.validation.ValidationTool;
import model.Category;
import model.Order;
import model.Product;
import model.Store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryController implements ActionForModel, ValidationTool {
    List<Category> categories = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String path = "category.txt";

    public CategoryController() {
        categories.add(new Category(1, "fridge"));
        categories.add(new Category(2, "TV"));
        categories.add(new Category(3, "laptop"));
    }

    @Override
    public void display() {
        System.out.println("------DISPLAY CATEGORY------");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD CATEGORY------");
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
        Category newCategory = new Category(id, name);
        categories.add(newCategory);
        System.out.println("ADDED SUCCESSFULLY!");
        System.out.println(newCategory);
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE CATEGORY------");
        System.out.println("Remove this ID: ");
        while (true) {
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Category category : categories) {
                if (category.getId() == id) {
                    isAvailable = true;
                    categories.remove(category);
                    break;
                }
            }
            if (isAvailable) {
                System.out.println("CATEGORY ID " + id + " HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("CATEGORY ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH CATEGORY------");
        System.out.println("Enter ID or Name: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Category category : categories) {
            if (String.valueOf(category.getId()).equals(searchItem) || category.getName().equalsIgnoreCase(searchItem)) {
                System.out.println("FOUND! " + category);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("STORE NOT FOUND!");
        }
    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Category category : categories) {
                oos.writeObject(category);
            }
            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE WRITING TO FILE " + path);
    }

    public void readFromFile() {
        System.out.println("------READ FROM FILE------");
        List<Category> readCategories = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Category category = (Category) ois.readObject();
                    if (category != null) {
                        readCategories.add(category);
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
        List<Category> categoryDataFromFile = readCategories;
        for (Category category : categoryDataFromFile){
            System.out.println(category);
        }
    }
}
