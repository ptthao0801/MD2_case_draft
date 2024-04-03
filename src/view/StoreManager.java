package view;

import controller.CustomerController;
import controller.EmployeeController;
import controller.OrderController;
import controller.menu.EmployeeMenuController;
import controller.menu.ManagerMenuController;
import model.*;

import java.util.Scanner;

import static controller.EmployeeController.roleCheck;
import static model.EmployeeType.MANAGER;

public class StoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerController customer = new CustomerController();
        OrderController order = new OrderController();
        Store storeHN = new StoreHN();
        Store storeHCM = new StoreHCM();
        EmployeeMenuController eMenu = new EmployeeMenuController();
        ManagerMenuController mMenu = new ManagerMenuController();

        System.out.println("Nhập mã nhân viên:");
        String employeeId = scanner.nextLine();
        EmployeeType role = roleCheck(employeeId);
        switch (role) {
            case MANAGER:
                // Thêm xử lý cho quản lý
                System.out.println("đây là manager");
                // manager menu
                mMenu.display();
                break;
            case EMPLOYEE:
                System.out.println("day la employee");
                // employee menu
                eMenu.display();
                break;
            default:
                System.out.println("Nhân viên không có quyền truy cập.");
                break;
        }
    }
}
