package controller.menu.managerMenu;

import controller.EmployeeController;
import controller.menu.ActionForMenu;

import java.util.Scanner;

public class ManageEmployee implements ActionForMenu {
    EmployeeController employee = new EmployeeController();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------MANAGE EMPLOYEE------");
        System.out.println("0. Back");
        System.out.println("1. Display");
        System.out.println("2. Add");
        System.out.println("3. Remove");
        System.out.println("4. Search");
        System.out.println("5. Write to File");
        System.out.println("6. Read from File");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        int selection = scanner.nextInt();
        switch (selection){
            case 0:
                System.exit(0);
                break;
            case 1:
                employee.display();
                break;
            case 2:
                employee.add();
                break;
            case 3:
                employee.remove();
                break;
            case 4:
                employee.search();
                break;
            case 5:
                employee.writeToFile();
                break;
            case 6:
                employee.readFromFile();
                break;
            default:
                System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
                break;
        }
    }
}
