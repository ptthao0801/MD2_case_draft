package controller.menu.greetingMenu;

import controller.menu.ActionForMenu;
import model.StoreHCM;
import model.StoreHN;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GreetingMenuController implements ActionForMenu {
    StoreHCM storeHCM = new StoreHCM();
    StoreHN storeHN = new StoreHN();
    Scanner scanner = new Scanner(System.in);
    public void display(){
        System.out.println("------SELECT STORE------");
        System.out.println("0. Exit");
        System.out.println("1. HÀ NỘI");
        System.out.println("2. HỒ CHÍ MINH");
        System.out.println("-------------> Enter your selection: ");
    }

    @Override
    public void runBySelecTion() {
        boolean exit = false;
        while (!exit)
            try {
                display();
                int selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 0:
                        System.exit(0);
                        exit = true;
                        break;
                    case 1:
                        storeHN.greeting();
                        exit = true;
                        break;
                    case 2:
                        storeHCM.greeting();
                        exit = true;
                        break;
                    default:
                        System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
                        break;
                }
            } catch (NumberFormatException ignored) {
                System.out.println("WARNING: INVALID OPTION. Please re-enter: ");
            }
        }
    }

//    public static void main(String[] args) {
//        GreetingMenuController greetingMenuController = new GreetingMenuController();
//        greetingMenuController.runBySelecTion();
//    }

