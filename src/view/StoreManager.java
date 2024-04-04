package view;

import controller.CustomerController;
import controller.OrderController;
import controller.menu.employeeMenu.EmployeeMenuController;
import controller.menu.managerMenu.ManagerMenuController;
import controller.menu.greetingMenu.GreetingMenuController;
import model.*;

import java.util.Scanner;

import static controller.EmployeeController.roleCheck;

public class StoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerController customer = new CustomerController();
        OrderController order = new OrderController();
        Store storeHN = new StoreHN();
        Store storeHCM = new StoreHCM();
        EmployeeMenuController eMenu = new EmployeeMenuController();
        ManagerMenuController mMenu = new ManagerMenuController();
        GreetingMenuController sMenu = new GreetingMenuController();

        // Greeting
        sMenu.display();
        sMenu.runBySelecTion();

        System.out.println("Enter your Staff ID:");
        String employeeId = scanner.nextLine();
        EmployeeType role = roleCheck(employeeId);
        switch (role) {
            case MANAGER:
                // Thêm xử lý cho quản lý
                System.out.println("Hi Manager! Please select an option from the menu");
                // manager menu
                mMenu.runBySelecTion();
                break;
            case EMPLOYEE:
                System.out.println("Hi! Please select an option from the menu");
                // employee menu
                eMenu.runBySelecTion();
                break;
            default:
                System.out.println("WARNING: You have no access.");
                break;
        }
    }
}
