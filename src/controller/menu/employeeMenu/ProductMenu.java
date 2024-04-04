package controller.menu.employeeMenu;

import controller.ProductController;
import controller.menu.ActionForMenu;

import java.util.Scanner;

public class ProductMenu implements ActionForMenu {
    ProductController product = new ProductController();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("------PRODUCT MENU------");
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
        boolean exitProductMenu = false;

        while (!exitProductMenu) {
            display();
            int selection = scanner.nextInt();
            switch (selection) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    product.display();
                    break;
                case 2:
                    product.add();
                    break;
                case 3:
                    product.remove();
                    break;
                case 4:
                    product.search();
                    break;
                case 5:
                    product.writeToFile();
                    break;
                case 6:
                    product.readFromFile();
                    break;
                case 7:
                    exitProductMenu = true; // Đánh dấu đã thoát khỏi menu Product Menu
                    break;
                default:
                    System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
                    break;
            }
        }
    }
}
