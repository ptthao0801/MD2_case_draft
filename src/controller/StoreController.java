package controller;

import controller.validation.ValidationTool;
import model.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreController implements ActionForModel, ValidationTool {
    List<Store> stores = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------DISPLAY STORE------");
        for (Store store:stores){
            System.out.println(store);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD STORE------");
        System.out.println("1. Add Store Ha Noi");
        System.out.println("2. Add Store Ho Chi Minh");
        System.out.println("-------------> Enter your selection: ");
        int choice;

        while (true){
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (ValidationTool.idValidation(choice)) {
                    break;
                } else {
                    System.out.println("Selection must be a positive number. Please re-enter: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Selection must be a number. Please re-enter: ");
            }
        }

        switch (choice){
            case 1: // add HN
                System.out.println("Add new Ha Noi Store ID: ");
                int idHn;
                while (true) {
                    try {
                        idHn = Integer.parseInt(scanner.nextLine());
                        if (ValidationTool.idValidation(idHn)) {
                            break;
                        } else {
                            System.out.println("ID must be a positive number. Please re-enter: ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. ID must be a number. Please re-enter: ");
                    }
                }
                StoreHN storeHn = new StoreHN(idHn);
                stores.add(storeHn);
                System.out.println("ADDED SUCCESSFULLY!");
                break;
            case 2: // add HCM
                System.out.println("Add new Ho Chi Minh Store ID: ");
                int idHcm;
                while (true) {
                    try {
                        idHcm = Integer.parseInt(scanner.nextLine());
                        if (ValidationTool.idValidation(idHcm)) {
                            break;
                        } else {
                            System.out.println("ID must be a positive number. Please re-enter: ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. ID must be a number. Please re-enter: ");
                    }
                }
                StoreHCM storeHcm = new StoreHCM(idHcm);
                stores.add(storeHcm);
                System.out.println("ADDED SUCCESSFULLY!");
                break;
            default:
                System.out.println("Invalid option. Please re-enter: ");
                break;
        }
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE STORE------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            int id = scanner.nextInt();
            for (Store store:stores){
                if (store.getId()==id){
                    isAvailable = true;
                    stores.remove(store);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("STORE ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("STORE ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH STORE------");
        System.out.println("Enter ID or Name: ");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Store store: stores) {
            if (String.valueOf(store.getId()).equals(searchItem) || store.getName().equalsIgnoreCase(searchItem)) {
                System.out.println("FOUND! " + store);
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
        String path = "store.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Store store : stores) {
                oos.writeObject(store);
                oos.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE WRITING TO FILE "+ path);
    }

    @Override
    public void readFromFile() {

    }
}
