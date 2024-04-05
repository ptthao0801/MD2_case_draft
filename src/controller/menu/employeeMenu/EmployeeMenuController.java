package controller.menu.employeeMenu;

import controller.facade.Facade;
import controller.menu.ActionForMenu;

import java.util.Scanner;

public class EmployeeMenuController implements ActionForMenu {
    ProductMenu productMenu = new ProductMenu();
    CategoryMenu categoryMenu = new CategoryMenu();
    CustomerMenu customerMenu = new CustomerMenu();
    Facade facade = new Facade();
    OrderMenu orderMenu = new OrderMenu();
    StoreMenu storeMenu = new StoreMenu();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------MENU FOR EMPLOYEE------");
        System.out.println("0. Exit");
        System.out.println("1. Manage Products");
        System.out.println("2. Manage Categories");
        System.out.println("3. Manage Customers");
        System.out.println("4. Manage Orders");
        System.out.println("5. Manage Stores");
        System.out.println("6. Display All Products & Category");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        while (true){
            display();
            int selection = Integer.parseInt(scanner.nextLine());
            switch (selection){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    productMenu.runBySelecTion();
                    break;
                case 2:
                    categoryMenu.runBySelecTion();
                    break;
                case 3:
                    customerMenu.runBySelecTion();
                    break;
                case 4:
                    orderMenu.runBySelecTion();
                    break;
                case 5:
                    storeMenu.runBySelecTion();
                    break;
                case 6:
                    facade.displayProductAndCategory();
                    break;
                default:
                    System.out.println("WARNING: Invalid option. Please re-enter: ");
                    break;
            }
        }
    }
}
