package controller.menu.employeeMenu;

import controller.StoreController;
import controller.menu.ActionForMenu;

import java.util.Scanner;

public class StoreMenu implements ActionForMenu {
    StoreController store = new StoreController();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------STORE MENU------");
        System.out.println("0. Exit");
        System.out.println("1. Display");
        System.out.println("2. Add");
        System.out.println("3. Remove");
        System.out.println("4. Search");
        System.out.println("5. Write to File");
        System.out.println("6. Read from File");
        System.out.println("7. Back");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        boolean exit = false;
        while (!exit){
            display();
            int selection = scanner.nextInt();
            switch (selection){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    store.display();
                    break;
                case 2:
                    store.add();
                    break;
                case 3:
                    store.remove();
                    break;
                case 4:
                    store.search();
                    break;
                case 5:
                    store.writeToFile();
                    break;
                case 6:
                    store.readFromFile();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
            }
        }

    }
}
