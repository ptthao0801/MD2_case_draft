package controller.menu.managerMenu;

import controller.menu.ActionForMenu;

import java.util.Scanner;

public class ManagerMenuController implements ActionForMenu {
    ManageEmployee employeeMenu = new ManageEmployee();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------MENU FOR MANAGER------");
        System.out.println("0. Exit");
        System.out.println("1. Manage Employees");
        System.out.println("2. Check Top 5 Products by Sales");
        System.out.println("3. Check Top 5 Customers by Order Values");
        System.out.println("4. Remove all Products");
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
                    employeeMenu.display();
                    employeeMenu.runBySelecTion();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    System.out.println("WARNING: Invalid option. Please re-enter: ");
                    break;
            }
        }
    }
}
