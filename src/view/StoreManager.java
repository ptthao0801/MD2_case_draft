package view;

import controller.menu.employeeMenu.EmployeeMenuController;
import controller.menu.managerMenu.ManagerMenuController;
import controller.menu.greetingMenu.GreetingMenuController;
import model.*;

import java.util.Scanner;

import static controller.EmployeeController.roleCheck;

public class StoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeMenuController eMenu = new EmployeeMenuController();
        ManagerMenuController mMenu = new ManagerMenuController();
        GreetingMenuController greetingMenu = new GreetingMenuController();

        // Greeting
        greetingMenu.runBySelecTion();

        System.out.println("Enter your Staff ID:");
        System.out.println("(*NOTE: Manager Staff ID starts with 'M', Employee Staff ID starts with any other characters)");
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
