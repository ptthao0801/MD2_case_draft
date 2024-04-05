package controller.menu.managerMenu;

import controller.OrderController;
import controller.facade.Facade;
import controller.menu.ActionForMenu;

import java.util.Scanner;

public class ManagerMenuController implements ActionForMenu {
    OrderController orderController = new OrderController();
    Facade facade = new Facade();
    ManageEmployee employeeMenu = new ManageEmployee();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        System.out.println("------MENU FOR MANAGER------");
        System.out.println("0. Exit");
        System.out.println("1. Manage Employees");
        System.out.println("2. Show Total Sales Value by Product ID");
        System.out.println("3. Check Top 10 Products by Sales Value");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        while (true){
            try{
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
                        orderController.getOrderValueByIdList();
                        break;
                    case 3:
                        facade.getTop10Products();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("WARNING: Invalid option. Please re-enter: ");
                        break;
                }
            } catch (NumberFormatException ignored){
                System.out.println("WARNING: Invalid option. Please re-enter: ");
            }
        }
    }
}
